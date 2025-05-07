package com.backend.webatrio.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
public class PersonWithJobDTO {

    @NotBlank(message = "Le prénom est obligatoire")
    @Parameter(description = "Prénom de la personne")
    private String firstName;

    @NotBlank(message = "Le nom est obligatoire")
    @Parameter(description = "Nom de la personne")
    private String lastName;

    @Parameter(description = "Âge de la personne")
    private int age;

    @Parameter(description = "Liste des emplois actuels de la personne")
    private List<JobDTO> currentJobs;
}
