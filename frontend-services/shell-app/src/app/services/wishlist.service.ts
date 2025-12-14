import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { ApiConfigService } from './api-config.service';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {
  private apiUrl: string;
  private wishlistItems = new BehaviorSubject<any[]>([]);
  public wishlistItems$ = this.wishlistItems.asObservable();
  private notificationSubject = new BehaviorSubject<{show: boolean, message: string}>({show: false, message: ''});
  public notification$ = this.notificationSubject.asObservable();

  constructor(private http: HttpClient, private authService: AuthService, private apiConfig: ApiConfigService) {
    this.apiUrl = this.apiConfig.getApiUrl('wishlist');
    this.loadWishlist();
  }

  private getHeaders(): HttpHeaders {
    const token = this.authService.getToken();
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  }

  private getUserId(): number {
    const user = this.authService.getCurrentUser();
    return user?.id || 1;
  }

  loadWishlist(): void {
    const userId = this.getUserId();
    this.http.get<any>(`${this.apiUrl}/${userId}`).subscribe({
      next: (response) => {
        this.wishlistItems.next(response.productIds || []);
      },
      error: (error) => console.error('Error loading wishlist:', error)
    });
  }

  addToWishlist(productId: number): Observable<any> {
    const userId = this.getUserId();
    const request = this.http.post(`${this.apiUrl}/${userId}/add/${productId}`, {});
    request.subscribe({
      next: () => {
        this.loadWishlist();
        this.showNotification('Added to wishlist!');
      }
    });
    return request;
  }

  showNotification(message: string): void {
    this.notificationSubject.next({show: true, message});
    setTimeout(() => this.notificationSubject.next({show: false, message: ''}), 3000);
  }

  removeFromWishlist(productId: number): Observable<any> {
    const userId = this.getUserId();
    return this.http.delete(`${this.apiUrl}/${userId}/remove/${productId}`);
  }

  isInWishlist(productId: number): boolean {
    return this.wishlistItems.value.some(item => item.id === productId);
  }

  getWishlistCount(): number {
    return this.wishlistItems.value.length;
  }
}
