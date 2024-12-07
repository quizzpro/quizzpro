import { Component } from '@angular/core';
import { SignupService, responsablerh, commercial } from '../signup.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent {
  userType: string = ''; // Définit le type d'utilisateur sélectionné
  commercial: commercial = {
    id: 0,
    nom: '',
    prenom: '',
    email: '',
    password: '',
    num: '',
    adresse: '',
    datenaissance: new Date(),
    statut: 'INACTIF',
  };
  responsableRH: responsablerh = {
    id: 0,
    nom: '',
    prenom: '',
    email: '',
    password: '',
    num: '',
    adresse: '',
    datenaissance: new Date(),
    statut: 'INACTIF',
    numero: undefined
  };

  constructor(private signupService: SignupService) {}

  // Définit le type d'utilisateur sélectionné
  setUserType(type: string) {
    this.userType = type;
  }

  // Soumet les données au service approprié
  onSubmit() {
    if (this.userType === 'commercial') {
      this.signupService.createCommercial(this.commercial).subscribe(
        (response) => {
          console.log('Commercial ajouté avec succès:', response);
          alert('Inscription réussie pour Commercial !');
        },
        (error) => {
          console.error('Erreur lors de l’inscription:', error);
          alert('Une erreur est survenue pour le Commercial.');
        }
      );
    } else if (this.userType === 'responsablerh') {
      this.signupService.createResponsablerh(this.responsableRH).subscribe(
        (response) => {
          console.log('Responsable RH ajouté avec succès:', response);
          alert('Inscription réussie pour Responsable RH !');
        },
        (error) => {
          console.error('Erreur lors de l’inscription:', error);
          alert('Une erreur est survenue pour le Responsable RH.');
        }
      );
    } else {
      alert('Veuillez sélectionner un type d’utilisateur.');
    }
  }
}
