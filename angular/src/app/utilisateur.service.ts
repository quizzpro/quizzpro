import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export enum Statut {
  INACTIF = 'INACTIF',
  ACTIF = 'ACTIF',
  EN_ATTENTE = 'EN_ATTENTE',
}

export enum Role {
  COMMERCIAL = 'COMMERCIAL',
  RESPONSABLE_RH = 'RESPONSABLE_RH',
}

export interface Utilisateur {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  numTel: string;
  adresse: string;
  password: string;
  datenaissance: Date;
  statut: Statut;
  role: Role;
}

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private apiUrl = 'http://localhost:8081/utilisateurs';

  constructor(private http: HttpClient) {}

  getAllUtilisateurs(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.apiUrl}/getAllUtilisateurs`);
  }

  addUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.apiUrl}/addUtilisateur`, utilisateur);
  }

  updateUtilisateur(id: number, utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(`${this.apiUrl}/${id}`, utilisateur);
  }

  deleteUtilisateur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
