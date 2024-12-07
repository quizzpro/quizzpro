import { Component, OnInit } from '@angular/core';
import { UtilisateurService, Utilisateur, Statut, Role } from '../utilisateur.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css'],
})
export class UtilisateurComponent implements OnInit {
  utilisateurs: Utilisateur[] = [];
  isEditMode: boolean = false;

  currentUtilisateur: Utilisateur = {
    id: 0,
    nom: '',
    prenom: '',
    email: '',
    numTel: '',
    adresse: '',
    password: '',
    datenaissance: new Date(),
    statut: Statut.ACTIF,
    role:Role.RESPONSABLE_RH||Role.COMMERCIAL,
  };

  constructor(private UtilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    this.fetchUtilisateurs();
  }

  fetchUtilisateurs(): void {
    this.UtilisateurService.getAllUtilisateurs().subscribe(
      (data) => {
        this.utilisateurs = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des utilisateurs:', error);
      }
    );
  }

  onSubmit(): void {
    if (this.isEditMode) {
      this.UtilisateurService.updateUtilisateur(this.currentUtilisateur.id, this.currentUtilisateur).subscribe(
        () => {
          this.fetchUtilisateurs();
          this.resetForm();
        },
        (error) => console.error('Erreur lors de la mise à jour:', error)
      );
    } else {
      this.UtilisateurService.addUtilisateur(this.currentUtilisateur).subscribe(
        () => {
          this.fetchUtilisateurs();
          this.resetForm();
        },
        (error) => console.error('Erreur lors de l\'ajout:', error)
      );
    }
  }

  editUtilisateur(utilisateur: Utilisateur): void {
    this.isEditMode = true;
    this.currentUtilisateur = { ...utilisateur };
  }

  deleteUtilisateur(id: number): void {
    this.UtilisateurService.deleteUtilisateur(id).subscribe(
      () => this.fetchUtilisateurs(),
      (error) => console.error('Erreur lors de la suppression:', error)
    );
  }

  resetForm(): void {
    this.isEditMode = false;
    this.currentUtilisateur = {
      id: 0,
      nom: '',
      prenom: '',
      email: '',
      numTel: '',
      adresse: '',
      password: '',
      datenaissance: new Date(),
      statut: Statut.ACTIF,
      role: Role.RESPONSABLE_RH||Role.COMMERCIAL,
    };
  }
}
