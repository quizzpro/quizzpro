import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  email = '';
  password = '';
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.email, this.password).subscribe({
      next: (user) => {
        this.authService.saveUser(user);
        const role = user.role;

        if (role === 'ADMIN') this.router.navigate(['/admin-dashboard']);
        else if (role === 'COMMERCIAL') this.router.navigate(['/commercial-dashboard']);
        else if (role === 'RESPONSABLERH') this.router.navigate(['/responsablerh-dashboard']);
      },
      error: () => {
        this.errorMessage = 'Invalid email or password!';
      },
    });
  }
}
