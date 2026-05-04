package io.github.David_Rn01.API_OFC.dto;

import io.github.David_Rn01.API_OFC.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentResponseDTO {

    //Remover o ID abaixo após testes
    @NotBlank
    private UUID id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "instituição é obrigatório")
    private String school;

    @NotBlank(message = "Cidade é obrigatória")
    private String city;

    @NotBlank(message = "Número de celular obrigatório")
    private String number;

    private Role role;
}
