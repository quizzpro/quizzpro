package quizzpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizzpro.app.model.user;
import quizzpro.app.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200") // Permet l'accès depuis l'interface Angular
public class UserController {

    @Autowired
    private UserService userService;

    // Récupérer les utilisateurs en attente par type
    @GetMapping("/users")
    public ResponseEntity<List<user>> getUsersEnAttente(@RequestParam(required = false) String type) {
        List<user> users;
        if (type != null) {
            users = userService.getUsersEnAttente(type);
        } else {
            users = userService.getAllUsersEnAttente();
        }
        return ResponseEntity.ok(users);
    }

    // Valider un utilisateur
    @PutMapping("/users/{id}/valider")
    public ResponseEntity<String> validerUser(@PathVariable Long id) {
        userService.validerUser(id);
        return ResponseEntity.ok().body("{\"message\":\"Utilisateur validé avec succès.\"}");

    }

    // Rejeter un utilisateur
    @PutMapping("/users/{id}/rejeter")
    public ResponseEntity<String> rejeterUser(@PathVariable Long id) {
        userService.rejeterUser(id);
        return ResponseEntity.ok().body("{\"message\":\"Utilisateur rejeté avec succès.\"}");
    }
}