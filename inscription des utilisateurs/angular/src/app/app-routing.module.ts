import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InscriptionComponent } from './inscription/inscription.component'; // Import du composant Inscription

const routes: Routes = [
  { path: '', redirectTo: 'inscription', pathMatch: 'full' }, 
  { path: 'inscription', component: InscriptionComponent }, 
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
