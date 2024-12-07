package SpringBoot.services;

import SpringBoot.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur findUtilisateurById(Long id);
    Utilisateur addUtilisateur(Utilisateur utilisateur);
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
    List<Utilisateur> findByRole(Utilisateur.Role role);
    Optional<Utilisateur> authenticate(String email, String password);
    void validerUser(Long id);
    void rejeterUser(Long id);
    List<Utilisateur> getUsersEnAttente(String type);
}
