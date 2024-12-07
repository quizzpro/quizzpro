package com.quizpro.springboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Enumerated(EnumType.STRING)  // Utilisation de l'Enum pour les rôles
    private Role role; // ADMIN, COMMERCIAL, RESPONSABLERH

    private String name;   // Commercial et ResponsableRH uniquement
    private String address; // Commercial et ResponsableRH uniquement
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    private String phone; // Commercial et ResponsableRH uniquement

    private LocalDate birthDate; // Commercial et ResponsableRH uniquement

    // Constructeurs

    public User() {
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email, String password, Role role, String name, String address, String phone, LocalDate birthDate) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
