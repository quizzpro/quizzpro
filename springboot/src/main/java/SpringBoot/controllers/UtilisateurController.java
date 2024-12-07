package SpringBoot.controllers;

import SpringBoot.entities.Utilisateur;
import SpringBoot.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Récupérer tous les utilisateurs actifs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Ajouter un nouvel utilisateur
    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.addUtilisateur(utilisateur);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.findUtilisateurById(id);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateur(id, utilisateur);
    }

    // Supprimer (désactiver) un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }

    // Récupérer les utilisateurs par rôle
    @GetMapping("/role/{role}")
    public List<Utilisateur> getUtilisateursByRole(@PathVariable Utilisateur.Role role) {
        return utilisateurService.findByRole(role);
    }

    // Authentifier un utilisateur par email et mot de passe
    @PostMapping("/auth")
    public Optional<Utilisateur> authenticate(@RequestBody Utilisateur credentials) {
        return utilisateurService.authenticate(credentials.getEmail(), credentials.getPassword());
    }

    // Valider un utilisateur en attente
    @PutMapping("/{id}/valider")
    public void validerUtilisateur(@PathVariable Long id) {
        utilisateurService.validerUser(id);
    }

    // Rejeter un utilisateur en attente
    @PutMapping("/{id}/rejeter")
    public void rejeterUtilisateur(@PathVariable Long id) {
        utilisateurService.rejeterUser(id);
    }

    // Récupérer les utilisateurs en attente avec un filtre optionnel sur le type (rôle)
    @GetMapping("/en-attente")
    public List<Utilisateur> getUsersEnAttente(@RequestParam(value = "type", required = false) String type) {
        return utilisateurService.getUsersEnAttente(type);
    }
}
