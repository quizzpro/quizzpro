import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators'; 


export interface User {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  statut: number;
  type: string;
}

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  private apiUrl = 'http://localhost:8081/user'; 

  constructor(private http: HttpClient) {}

 
  getutilisateurs(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/users`).pipe(
      catchError((error) => this.handleError(error))
    );
  }

 
  validerUtilisateur(id: number): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/users/${id}/valider`, {}).pipe(
      catchError((error) => this.handleError(error))
    );
  }

  
  refuserUtilisateur(id: number): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/users/${id}/rejeter`, {}).pipe(
      catchError((error) => this.handleError(error))
    );
  }

 
  private handleError(error: any): Observable<never> {
    console.error('Erreur détectée:', error);
    return throwError(() => new Error(error.message || 'Erreur inconnue'));
  }
}
