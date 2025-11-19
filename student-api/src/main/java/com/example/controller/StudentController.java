package com.example.controller; // Adapté à ton projet

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200") // Autorise ton Angular
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // Récupérer tout le monde
    @GetMapping
    public List<Student> all() {
        return repo.findAll();
    }

    // Récupérer un seul par ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer (avec validation âge > 20)
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Student s) {
        if (s.getAge() < 20) {
            return ResponseEntity.badRequest().body("Student must be at least 20 years old");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(s));
    }

    // Mettre à jour
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Student s) {
        if (s.getAge() < 20) {
            return ResponseEntity.badRequest().body("Student must be at least 20 years old");
        }
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        s.setId(id);
        return ResponseEntity.ok(repo.save(s));
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}