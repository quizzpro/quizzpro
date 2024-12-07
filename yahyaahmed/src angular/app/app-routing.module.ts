import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CommercialDashboardComponent } from './commercial-dashboard/commercial-dashboard.component';
import { ResponsablerhDashboardComponent } from './responsablerh-dashboard/responsablerh-dashboard.component';
import { ProfileComponent } from './profile/profile.component';

import { AuthGuard } from './guards/auth.guard'; // Créez ce Guard
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: '', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [AuthGuard], data: { role: 'ADMIN' } },
  { path: 'commercial-dashboard', component: CommercialDashboardComponent, canActivate: [AuthGuard], data: { role: 'COMMERCIAL' } },
  { path: 'responsablerh-dashboard', component: ResponsablerhDashboardComponent, canActivate: [AuthGuard], data: { role: 'RESPONSABLERH' } },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
