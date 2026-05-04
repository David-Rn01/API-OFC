package io.github.David_Rn01.API_OFC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    // Universal Unic ID

    @NotEmpty
    @Size(min = 20, max = 255)
    private String texto;
}
