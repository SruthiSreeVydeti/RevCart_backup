import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { ApiConfigService } from './api-config.service';

export interface Address {
  id?: number;
  fullName: string;
  phone: string;
  line1: string;
  line2?: string;
  city: string;
  state: string;
  pincode: string;
  isDefault?: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  private apiUrl: string;
  private addressesSubject = new BehaviorSubject<Address[]>([]);
  public addresses$ = this.addressesSubject.asObservable();

  constructor(private http: HttpClient, private apiConfig: ApiConfigService) {
    this.apiUrl = this.apiConfig.getApiUrl('addresses');
    this.loadAddresses();
  }

  private getUserId(): number {
    const user = JSON.parse(localStorage.getItem('currentUser') || '{}');
    return user?.id || 1;
  }

  loadAddresses(): void {
    const userId = this.getUserId();
    this.http.get<Address[]>(`${this.apiUrl}?userId=${userId}`).subscribe({
      next: (addresses) => this.addressesSubject.next(addresses),
      error: (error) => console.error('Error loading addresses:', error)
    });
  }

  saveAddress(address: Address): Observable<Address> {
    const userId = this.getUserId();
    const addressData = { ...address, userId };
    if (address.id) {
      return this.http.put<Address>(`${this.apiUrl}/${address.id}`, addressData);
    } else {
      return this.http.post<Address>(this.apiUrl, addressData);
    }
  }

  deleteAddress(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  setDefaultAddress(id: number): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}/default`, {});
  }

  getDefaultAddress(): Address | null {
    const addresses = this.addressesSubject.value;
    return addresses.find(addr => addr.isDefault) || addresses[0] || null;
  }
}