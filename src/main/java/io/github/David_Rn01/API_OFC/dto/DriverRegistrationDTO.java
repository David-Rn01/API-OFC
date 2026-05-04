package io.github.David_Rn01.API_OFC.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverRegistrationDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Número é obrigatório")
    private String number;

    @NotBlank(message = "Cidade é obrigatório")
    private String city;

    @NotBlank(message = "Placa do veículo obrigatório")
    private String plate;

    @NotBlank(message = "Número da CNH obrigatório")
    private String conductionNumber;

    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6)
    private String password;
}
