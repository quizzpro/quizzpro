package isetb.pi.quizzproo.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;

import java.util.Date;

import isetb.pi.quizzproo.entities.responsablerh.Statut;

@Entity
public class commercial implements Serializable {
	
	private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

   
    private String nom;

 
    private String prenom;

    
    private String email;
    
   
    private String password;

    
    private String num;
    private String adresse;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Statut statut;

    public enum Statut {
        ACTIF, EN_ATTENTE, INACTIF;
    }

    
    

   
  public commercial() {}
 

	//getter setter
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public Statut getStatut() {
		return statut;
	}
	
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	

	@Override
	public String toString() {
		return "commercial [id=" + id + 
				", nom=" + nom + 
				", prenom=" + prenom +
				", email=" + email +
				", password="+ password + 
				", num=" + num + 
				", adresse=" + adresse + 
				", datenaissance=" + datenaissance +
				", statut="+ statut + "]";
	}
	
}
