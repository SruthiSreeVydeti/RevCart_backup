import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink, Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  product: any;
  relatedProducts: any[] = [];
  quantity = 1;
  selectedSize: string = '';
  availableSizes: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private cartService: CartService,
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.loadProduct(id);
  }

  getSizesForProduct(product: any): string[] {
    if (product.category.includes('clothing')) {
      if (product.name.toLowerCase().includes('pant') || product.name.toLowerCase().includes('jeans')) {
        return ['28', '30', '32', '34', '36', '38', '40'];
      } else if (product.name.toLowerCase().includes('shirt') || product.name.toLowerCase().includes('t-shirt') || product.name.toLowerCase().includes('dress') || product.name.toLowerCase().includes('kurti')) {
        return ['XS', 'S', 'M', 'L', 'XL', 'XXL'];
      } else if (product.name.toLowerCase().includes('shoe')) {
        return ['5', '6', '7', '8', '9', '10', '11', '12'];
      }
    }
    return [];
  }

  loadProduct(id: string) {
    this.productService.getProductById(parseInt(id)).subscribe({
      next: (product) => {
        this.product = product;
        this.availableSizes = this.getSizesForProduct(this.product);
        if (this.availableSizes.length > 0) {
          this.selectedSize = this.availableSizes[0];
        }
      },
      error: (error) => {
        console.error('Error loading product:', error);
        this.router.navigate(['/products']);
      }
    });
  }



  increaseQuantity() {
    this.quantity++;
  }

  decreaseQuantity() {
    if (this.quantity > 1) {
      this.quantity--;
    }
  }

  addToCart(product?: any) {
    const productToAdd = product || this.product;
    const quantityToAdd = product ? 1 : this.quantity;
    
    if (this.availableSizes.length > 0 && !this.selectedSize) {
      alert('Please select a size');
      return;
    }
    
    const cartItem = { ...productToAdd };
    if (this.selectedSize) {
      cartItem.size = this.selectedSize;
    }
    this.cartService.addToCart(cartItem, quantityToAdd);
  }
}    