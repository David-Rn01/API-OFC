package io.github.David_Rn01.API_OFC.dto;

import jakarta.validation.constraints.NotBlank;

public class AlertDTO {
    @NotBlank
    private String texto;
}
