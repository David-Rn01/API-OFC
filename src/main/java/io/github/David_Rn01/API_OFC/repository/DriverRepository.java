package io.github.David_Rn01.API_OFC.repository;

import io.github.David_Rn01.API_OFC.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    Optional<Driver> findById(UUID id);
    Driver findByEmail(String email);
    boolean existsByConductionNumber(String number);
}
