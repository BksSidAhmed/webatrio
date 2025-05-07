package com.backend.webatrio.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDTO {

    @NotBlank(message = "Le prénom est obligatoire")
    @Parameter(description = "Prénom de la personne")
    private String firstName;

    @NotBlank(message = "Le nom est obligatoire")
    @Parameter(description = "Nom de la personne")
    private String lastName;

    @Parameter(description = "Date de naissance de la personne")
    private LocalDate birthDate;
}
