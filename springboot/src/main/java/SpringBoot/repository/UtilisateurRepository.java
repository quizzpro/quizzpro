package SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findByStatut(Utilisateur.Statut statut);
    List<Utilisateur> findByRole(Utilisateur.Role role);
    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findByStatutAndRole(Utilisateur.Statut statut, String role);
}
