import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink, Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-forgot-password',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent {
  step = 1; // 1: email, 2: otp, 3: new password
  email = '';
  otp = '';
  newPassword = '';
  confirmPassword = '';
  isLoading = false;
  message = '';
  messageType = '';

  constructor(private authService: AuthService, private router: Router) {}

  sendOtp() {
    if (!this.email) {
      this.message = 'Please enter your email';
      this.messageType = 'error';
      return;
    }

    this.isLoading = true;
    this.authService.forgotPassword(this.email).subscribe({
      next: (response) => {
        this.message = 'OTP sent to your email';
        this.messageType = 'success';
        this.isLoading = false;
        this.step = 2;
      },
      error: (error) => {
        this.message = error.error?.message || 'Error sending OTP';
        this.messageType = 'error';
        this.isLoading = false;
      }
    });
  }

  verifyOtp() {
    if (!this.otp) {
      this.message = 'Please enter OTP';
      this.messageType = 'error';
      return;
    }

    this.isLoading = true;
    this.authService.verifyResetOtp(this.email, this.otp).subscribe({
      next: (response: any) => {
        if (response.valid) {
          this.message = 'OTP verified successfully';
          this.messageType = 'success';
          this.step = 3;
        } else {
          this.message = 'Invalid OTP';
          this.messageType = 'error';
        }
        this.isLoading = false;
      },
      error: (error) => {
        this.message = 'Invalid OTP';
        this.messageType = 'error';
        this.isLoading = false;
      }
    });
  }

  resetPassword() {
    if (!this.newPassword || !this.confirmPassword) {
      this.message = 'Please fill all fields';
      this.messageType = 'error';
      return;
    }

    if (this.newPassword !== this.confirmPassword) {
      this.message = 'Passwords do not match';
      this.messageType = 'error';
      return;
    }

    if (this.newPassword.length < 6) {
      this.message = 'Password must be at least 6 characters';
      this.messageType = 'error';
      return;
    }

    this.isLoading = true;
    this.authService.resetPassword(this.email, this.newPassword).subscribe({
      next: (response) => {
        this.message = 'Password reset successfully';
        this.messageType = 'success';
        this.isLoading = false;
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: (error) => {
        this.message = error.error?.message || 'Error resetting password';
        this.messageType = 'error';
        this.isLoading = false;
      }
    });
  }
}
