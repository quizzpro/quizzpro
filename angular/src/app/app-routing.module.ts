import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';

const routes: Routes = [
  { path: 'utlisateur', component: UtilisateurComponent },
  { path: '', redirectTo: '/utlisateur', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
