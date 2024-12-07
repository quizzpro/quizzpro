import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css'],
})
export class AdminDashboardComponent implements OnInit {
  user: any; // Utilisateur connecté (admin)
  users: any[] = []; // Liste des utilisateurs
  selectedUser: any = null; // Utilisateur sélectionné pour modification ou ajout
  isEditMode = false; // Mode édition ou ajout

  constructor(private authService: AuthService) {
    this.user = this.authService.getLoggedUser(); // Récupérer l'utilisateur connecté
  }

  ngOnInit() {
    this.loadUsers(); // Charger les utilisateurs au démarrage
  }

  // Charger la liste des utilisateurs
  loadUsers() {
    this.authService.getUsers().subscribe(
      (data) => {
        // Exclure les ADMIN de la liste
        this.users = data.filter((user) => user.role !== 'ADMIN');
      },
      (error) =>
        console.error('Erreur lors du chargement des utilisateurs', error)
    );
  }

  // Sélectionner un utilisateur pour modification
  editUser(user: any) {
    this.selectedUser = { ...user }; // Copier les données de l'utilisateur
    this.isEditMode = true;
  }

  // Passer en mode ajout
  addUser() {
    this.isEditMode = false;
    this.selectedUser = {
      id: null,
      name: '',
      birthDate: '',
      email: '',
      phone: '',
      address: '',
      password: '',
      role: '', // Permet de choisir un rôle
    };
  }

  // Sauvegarder ou ajouter un utilisateur
  onSubmit() {
    if (this.isEditMode) {
      // Mettre à jour l'utilisateur existant
      this.authService.updateUser(this.selectedUser.id, this.selectedUser).subscribe(
        () => {
          console.log('Utilisateur mis à jour');
          this.loadUsers();
          this.selectedUser = null;
          this.isEditMode = false;
        },
        (error) =>
          console.error('Erreur lors de la mise à jour de l\'utilisateur', error)
      );
    } else {
      // Ajouter un nouvel utilisateur
      this.authService.addUser(this.selectedUser).subscribe(
        () => {
          console.log('Utilisateur ajouté');
          this.loadUsers();
          this.selectedUser = null;
        },
        (error) =>
          console.error('Erreur lors de l\'ajout de l\'utilisateur', error)
      );
    }
  }

  // Supprimer un utilisateur
  deleteUser(userId: number) {
    if (confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?')) {
      this.authService.deleteUser(userId).subscribe(
        () => {
          this.loadUsers();
          console.log('Utilisateur supprimé');
        },
        (error) =>
          console.error('Erreur lors de la suppression de l\'utilisateur', error)
      );
    }
  }

  // Déconnexion de l'administrateur
  logout() {
    this.authService.logout();
  }
}
