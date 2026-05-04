package io.github.David_Rn01.API_OFC.repository;

import io.github.David_Rn01.API_OFC.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findById(UUID id);
    Student findByEmail(String email);
    boolean existsByCpf(String cpf);
}
