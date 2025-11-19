package com.example.repository; // Adapté à ton projet

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Rien à ajouter ! Spring crée tout automatiquement.
}