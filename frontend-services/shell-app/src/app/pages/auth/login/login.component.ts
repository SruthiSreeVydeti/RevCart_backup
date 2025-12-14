import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink, Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../../../services/auth.service';

declare var google: any;

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginData = {
    email: '',
    password: ''
  };
  rememberMe = false;
  showPassword = false;
  isLoading = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.checkGoogleCallback();
  }

  checkGoogleCallback() {
    this.route.queryParams.subscribe(params => {
      const code = params['code'];
      if (code) {
        this.isLoading = true;
        this.authService.googleCallback(code).subscribe({
          next: (response) => {
            this.router.navigate(['/home']);
            this.isLoading = false;
          },
          error: (error) => {
            console.error('Google callback error:', error);
            alert('Google login failed: ' + (error.error?.message || error.message));
            this.isLoading = false;
          }
        });
      }
    });
  }

  initializeGoogleSignIn() {
    if (typeof google !== 'undefined') {
      google.accounts.id.initialize({
        client_id: '648004032072-8nshi160au24pqaa1msg7vj0tgdk54vr.apps.googleusercontent.com',
        callback: (response: any) => this.handleGoogleLogin(response)
      });
      google.accounts.id.renderButton(
        document.getElementById('googleSignInButton'),
        { theme: 'outline', size: 'large' }
      );
    }
  }

  handleGoogleLogin(response: any) {
    if (response.credential) {
      this.isLoading = true;
      this.authService.googleLogin(response.credential).subscribe({
        next: (result) => {
          this.router.navigate(['/home']);
          this.isLoading = false;
        },
        error: (error) => {
          console.error('Google login error:', error);
          alert('Google login failed: ' + (error.error?.message || error.message));
          this.isLoading = false;
        }
      });
    }
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }

  onLogin() {
    this.isLoading = true;
    
    this.authService.login(this.loginData.email, this.loginData.password).subscribe({
      next: (response) => {
        // Check if user is admin
        if (this.authService.isAdmin()) {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/home']);
        }
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Login error:', error);
        alert('Login failed: ' + (error.error?.message || error.message || 'Invalid credentials'));
        this.isLoading = false;
      }
    });
  }
}
