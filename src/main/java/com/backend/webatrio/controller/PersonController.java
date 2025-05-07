package com.backend.webatrio.controller;

import com.backend.webatrio.dto.PersonDTO;
import com.backend.webatrio.entity.Person;
import com.backend.webatrio.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
@Tag(name = "Person", description = "Endpoints de gestion des personnes")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @Operation(summary = "Créer une personne (âge < 150 ans)")
    @ApiResponse(responseCode = "200", description = "Personne créée avec succès")
    public ResponseEntity<Person> createPerson(@RequestBody  @Valid PersonDTO personDTO) {
        return ResponseEntity.ok(personService.createPerson(personDTO));
    }
}
