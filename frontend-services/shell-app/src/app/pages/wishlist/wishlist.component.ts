import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { WishlistService } from '../../services/wishlist.service';
import { CartService } from '../../services/cart.service';
import { ProductService } from '../../services/product.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-wishlist',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.scss']
})
export class WishlistComponent implements OnInit {
  wishlistItems: any[] = [];

  constructor(
    private wishlistService: WishlistService,
    private cartService: CartService,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.wishlistService.wishlistItems$.subscribe(productIds => {
      if (productIds && productIds.length > 0) {
        const requests = productIds.map(id => this.productService.getProductById(id));
        forkJoin(requests).subscribe({
          next: (products) => {
            this.wishlistItems = products;
          },
          error: (error) => console.error('Error loading wishlist products:', error)
        });
      } else {
        this.wishlistItems = [];
      }
    });
  }

  removeFromWishlist(productId: number): void {
    this.wishlistService.removeFromWishlist(productId).subscribe({
      next: () => {
        this.wishlistItems = this.wishlistItems.filter(item => item.id !== productId);
        this.wishlistService.loadWishlist();
      },
      error: (error) => {
        console.error('Error removing from wishlist:', error);
        alert('Failed to remove item from wishlist');
      }
    });
  }

  addToCart(product: any): void {
    this.cartService.addToCart(product);
    this.removeFromWishlist(product.id);
  }
}
