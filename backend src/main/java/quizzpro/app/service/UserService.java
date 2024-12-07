package quizzpro.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quizzpro.app.model.user;
import quizzpro.app.repository.userRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    // Récupérer les utilisateurs en attente par type
    public List<user> getUsersEnAttente(String type) {
        if (type != null) {
            return userRepository.findByStatutAndType(0, type); // Statut 0 = "En attente"
        }
        return userRepository.findByStatut(0); // Statut 0 = "En attente"
    }

    // Récupérer tous les utilisateurs en attente
    public List<user> getAllUsersEnAttente() {
        return userRepository.findByStatut(0); // Statut 0 = "En attente"
    }

    // Valider un utilisateur
    @Transactional
    public void validerUser(Long id) {
        user utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé pour l'ID : " + id));
        utilisateur.setStatut(1); // Statut 1 = "Validé"
        userRepository.save(utilisateur);
    }

    // Rejeter un utilisateur
    @Transactional
    public void rejeterUser(Long id) {
        user utilisateur = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé pour l'ID : " + id));
        utilisateur.setStatut(-1); // Statut -1 = "Rejeté"
        userRepository.save(utilisateur);
    }
}