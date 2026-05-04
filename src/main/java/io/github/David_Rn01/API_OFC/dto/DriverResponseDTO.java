package io.github.David_Rn01.API_OFC.dto;

import io.github.David_Rn01.API_OFC.model.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponseDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String number;

    @NotBlank
    private String city;

    @NotBlank
    private String plate;

    @NotBlank
    private String conductionNumber;

    @NotBlank
    private Role role;
}
