import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent {
  user: any = {};

  constructor(private authService: AuthService, private http: HttpClient) {
    this.user = this.authService.getLoggedUser();
  }

  updateProfile() {
    this.http.put(`http://localhost:8081/api/users/${this.user.id}`, this.user).subscribe({
      next: (updatedUser) => {
        this.authService.saveUser(updatedUser);
        alert('Profile updated successfully!');
      },
      error: () => alert('Update failed.'),
    });
  }
}
