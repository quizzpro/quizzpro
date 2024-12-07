import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user = {
    email: '',
    password: '',
    role: '',
    name: '',
    address: '',
    phone: '',
    birthDate: '',
  };

  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  registerUser() {
    this.authService.register(this.user).subscribe({
      next: () => {
        alert('Inscription réussie !');
        this.router.navigate(['/login']); 
      },
      error: (err) => {
        this.errorMessage = err.error.message || 'Une erreur est survenue.';
      }
    });
  }
  navigateToLogin(): void {
    this.router.navigate(['/login']);
  }
}
