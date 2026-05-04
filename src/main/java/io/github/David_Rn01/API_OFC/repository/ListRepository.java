package io.github.David_Rn01.API_OFC.repository;

import io.github.David_Rn01.API_OFC.model.ListaPassageiros;
import io.github.David_Rn01.API_OFC.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ListRepository extends JpaRepository<ListaPassageiros, UUID> {

    Optional<ListaPassageiros> findById(UUID id);
    boolean existsByStudent(Student student);
}
