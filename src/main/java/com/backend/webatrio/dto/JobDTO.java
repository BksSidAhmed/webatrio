package com.backend.webatrio.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobDTO {

    @NotBlank(message = "Le nom de l'entreprise est obligatoire")
    @Parameter(description = "Nom de l'entreprise")
    private String company;

    @NotBlank(message = "Le poste est obligatoire")
    @Parameter(description = "Poste occupé")
    private String position;

    @Parameter(description = "Date de début de l'emploi")
    private LocalDate startDate;

    @Parameter(description = "Date de fin de l'emploi (peut être nulle si toujours en poste)")
    private LocalDate endDate;
}