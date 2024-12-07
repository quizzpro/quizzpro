import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
export interface responsablerh {
numero: any;
  id: number ;
  nom: string;
  prenom: string;
  email: string;
  num: string;
  adresse: string;
  password:string;
  datenaissance: Date;
  statut: string;
 
}
export interface commercial {
id: number
nom: string,
prenom: string,
email: string,
password: string,
num: string,
adresse: string,
datenaissance: Date,
statut:String 


}


@Injectable({
  providedIn: 'root', // Fournit automatiquement le service à l'échelle de l'application
})
export class SignupService {
  // URL pour les commerciaux
  private commercialUrl = 'http://localhost:8084/commercial';
  // URL pour les responsables RH
  private responsableRHUrl = 'http://localhost:8084/responsablerh';

  constructor(private http: HttpClient) {}
  createResponsablerh(responsablerh: responsablerh): Observable<responsablerh> { 
       return this.http.post<responsablerh>(this.responsableRHUrl+'/addresp', responsablerh); 
    }

    createCommercial(commercial: commercial): Observable<commercial> { 
        return this.http.post<commercial>(this.commercialUrl+'/add', commercial); 
     }
 
}
