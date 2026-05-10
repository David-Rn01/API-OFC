package io.github.David_Rn01.API_OFC.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertDTO {

    @NotBlank(message = "Texto obrigatório")
    private String texto;
}
