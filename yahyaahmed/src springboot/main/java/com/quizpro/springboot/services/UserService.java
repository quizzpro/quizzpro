package com.quizpro.springboot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizpro.springboot.entities.Role;
import com.quizpro.springboot.entities.User;
import com.quizpro.springboot.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }


    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            
            if (user.getRole() != Role.ADMIN) { 
                user.setAddress(updatedUser.getAddress());
                user.setPhone(updatedUser.getPhone());
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public User register(User user) {

    	if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Un utilisateur avec cet email existe déjà !");
        }
        return userRepository.save(user);
    }
    
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        
        return allUsers.stream()
                       .filter(user -> !user.getRole().equals("ADMIN")) 
                       .collect(Collectors.toList());
    }

    @Transactional
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }

}
