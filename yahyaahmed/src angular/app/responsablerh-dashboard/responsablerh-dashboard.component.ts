import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-responsablerh-dashboard',
  templateUrl: './responsablerh-dashboard.component.html',
  styleUrls: ['./responsablerh-dashboard.component.css']
})
export class ResponsablerhDashboardComponent {
  user: any;

  constructor(private authService: AuthService) {
    this.user = this.authService.getLoggedUser();
  }

  logout() {
    this.authService.logout();
  }
}
