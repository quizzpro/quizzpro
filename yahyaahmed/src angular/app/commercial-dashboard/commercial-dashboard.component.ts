import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-commercial-dashboard',
  templateUrl: './commercial-dashboard.component.html',
  styleUrls: ['./commercial-dashboard.component.css']
})
export class CommercialDashboardComponent {
  user: any;

  constructor(private authService: AuthService) {
    this.user = this.authService.getLoggedUser();
  }

  logout() {
    this.authService.logout();
  }
}
