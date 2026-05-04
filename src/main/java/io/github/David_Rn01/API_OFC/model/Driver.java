package io.github.David_Rn01.API_OFC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @NotEmpty
    private String name;

    @Column
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String number;

    @Column
    @NotEmpty
    private String city;

    @Column
    @NotEmpty
    private String plate;

    @Column(unique = true)
    private String conductionNumber;

    @Column
    @NotEmpty
    private String password;

    @Column
    private Role role;
}
