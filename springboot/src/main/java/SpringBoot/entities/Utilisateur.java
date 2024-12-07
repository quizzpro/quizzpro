package SpringBoot.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String numTel;
    private String password;
    private String adresse;

    @Temporal(TemporalType.DATE)
    private Date datenaissance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Statut {
        INACTIF,
        ACTIF,
        EN_ATTENTE
    }

    public enum Role {
        COMMERCIAL,
        RESPONSABLE_RH
    }

    public Utilisateur() {
    }
    public Utilisateur(Long id, String nom, String prenom, String email, String numTel, String password, String adresse,
			Date datenaissance, Statut statut, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTel = numTel;
		this.password = password;
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.statut = statut;
		this.role = role;
	}

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

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numTel="
                + numTel + ", password=" + password + ", adresse=" + adresse + ", datenaissance=" + datenaissance
                + ", statut=" + statut + ", role=" + role + "]";
    }
}
