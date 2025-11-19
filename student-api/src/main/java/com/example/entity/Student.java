package com.example.entity; // Adapté à ton projet

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name must be at least 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Last name must be at least 2 characters")
    private String lastName;

    @NotNull(message = "Birth date is required")
    private LocalDate birthDate;

    // Constructeur vide obligatoire pour JPA
    public Student() {}

    // Constructeur pour nous faciliter la vie
    public Student(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Méthode pour calculer l'âge automatiquement
    public int getAge() {
        if (this.birthDate == null) return 0;
        return LocalDate.now().getYear() - this.birthDate.getYear();
    }

    // --- Getters et Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}