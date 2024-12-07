import { Component, OnInit } from '@angular/core';
import { UsersService, User } from '../users.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-validation',
  templateUrl: './validation.component.html',
  styleUrls: ['./validation.component.css'],
})
export class ValidationComponent implements OnInit {
  utilisateurs: User[] = []; // Liste des utilisateurs

  constructor(private usersService: UsersService) {}

  // Charger les utilisateurs dès que le composant est initialisé
  ngOnInit(): void {
    this.loadUsers();
  }

  // Charger les utilisateurs depuis le service
  loadUsers(): void {
    this.usersService.getutilisateurs().subscribe(
      (data) => {
        this.utilisateurs = data;
      },
      (error) => {
        console.error('Erreur lors du chargement des utilisateurs:', error);
      }
    );
  }

  validerUtilisateur(utilisateur: User): void {
    Swal.fire({
      title: 'Confirmer la validation',
      text: `Voulez-vous vraiment valider ${utilisateur.nom} ${utilisateur.prenom} ?`,
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#28a745', // Vert pour "Valider"
      cancelButtonColor: '#3085d6', // Gris pour "Annuler"
      confirmButtonText: 'Oui, valider !',
      cancelButtonText: 'Annuler',
    }).then((result) => {
      if (result.isConfirmed) {
        // Appel au service pour valider l'utilisateur
        this.usersService.validerUtilisateur(utilisateur.id).subscribe({
          next: () => {
            utilisateur.statut = 1; // Statut mis à jour localement
            Swal.fire(
              'Validé !', // Titre
              `L'utilisateur ${utilisateur.nom} ${utilisateur.prenom} a été validé avec succès.`, // Message
              'success' // Type d'alerte
            );
            this.loadUsers(); // Recharger la liste
          },
          error: (error) => {
            console.error('Erreur lors de la validation de l\'utilisateur', error);
            Swal.fire('Erreur', 'Une erreur est survenue lors de la validation.', 'error');
          },
        });
      }
    });
  }
  

// Confirmation et refus de l'utilisateur
refuserUtilisateur(utilisateur: User): void {
  Swal.fire({
    title: 'Confirmer le refus',
    text: `Voulez-vous vraiment refuser ${utilisateur.nom} ${utilisateur.prenom} ?`,
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6',
    confirmButtonText: 'Oui, refuser !',
    cancelButtonText: 'Annuler',
  }).then((result) => {
    if (result.isConfirmed) {
      this.usersService.refuserUtilisateur(utilisateur.id).subscribe(
        () => {
          utilisateur.statut = -1; // Statut "refusé" - en supposant que -1 signifie refusé
          // Afficher une alerte de confirmation avec un message simple de succès
          Swal.fire(
            'Refusé !', // Titre de l'alerte
            `L'utilisateur ${utilisateur.nom} ${utilisateur.prenom} a été refusé.`, // Message
            'success' // Type de l'alerte (succès)
          );
          this.loadUsers(); // Recharge la liste après refus
        },
        (error) => {
          console.error('Erreur lors du refus de l\'utilisateur', error);
          Swal.fire('Erreur', 'Une erreur est survenue lors du refus.', 'error');
        }
      );
    }
  });
}


}