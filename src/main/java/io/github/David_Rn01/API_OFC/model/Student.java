package io.github.David_Rn01.API_OFC.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty
    @Column
    private String name;
    @NotEmpty
    @Column
    private String email;
    @Column(unique = true)
    private String cpf;
    @NotEmpty
    @Column
    private String school;

    @NotEmpty
    @Column
    private String city;

    @NotEmpty
    @Column
    private String password; //criptografar antes de ir para o banco de dados

    @NotEmpty
    @Column
    private String number;

    @Column
    private Role role;
}
