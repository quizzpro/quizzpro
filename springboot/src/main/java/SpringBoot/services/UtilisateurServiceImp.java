package SpringBoot.services;

import SpringBoot.entities.Utilisateur;
import SpringBoot.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepo.findByStatut(Utilisateur.Statut.ACTIF);
    }

    @Override
    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepo.findById(id)
                .filter(u -> u.getStatut() == Utilisateur.Statut.ACTIF)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé ou inactif"));
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        utilisateur.setStatut(Utilisateur.Statut.EN_ATTENTE);
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Utilisateur existing = findUtilisateurById(id);
        existing.setNom(utilisateur.getNom());
        existing.setPrenom(utilisateur.getPrenom());
        existing.setEmail(utilisateur.getEmail());
        existing.setPassword(utilisateur.getPassword());
        existing.setNumTel(utilisateur.getNumTel());
        existing.setAdresse(utilisateur.getAdresse());
        existing.setRole(utilisateur.getRole());
        return utilisateurRepo.save(existing);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        Utilisateur utilisateur = findUtilisateurById(id);
        utilisateur.setStatut(Utilisateur.Statut.INACTIF);
        utilisateurRepo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findByRole(Utilisateur.Role role) {
        return utilisateurRepo.findByRole(role);
    }

    @Override
    public Optional<Utilisateur> authenticate(String email, String password) {
        return utilisateurRepo.findByEmail(email)
                .filter(u -> u.getStatut() == Utilisateur.Statut.ACTIF && u.getPassword().equals(password));
    }

    @Override
    @Transactional
    public void validerUser(Long id) {
        Utilisateur utilisateur = findUtilisateurById(id);
        utilisateur.setStatut(Utilisateur.Statut.ACTIF);
        utilisateurRepo.save(utilisateur);
    }

    @Override
    @Transactional
    public void rejeterUser(Long id) {
        Utilisateur utilisateur = findUtilisateurById(id);
        utilisateur.setStatut(Utilisateur.Statut.INACTIF);
        utilisateurRepo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getUsersEnAttente(String type) {
        if (type != null) {
            return utilisateurRepo.findByStatutAndRole(Utilisateur.Statut.EN_ATTENTE, type);
        }
        return utilisateurRepo.findByStatut(Utilisateur.Statut.EN_ATTENTE);
    }
}
