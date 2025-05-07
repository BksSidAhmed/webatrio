package com.backend.webatrio.controller;

import com.backend.webatrio.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
@Tag(name = "Person", description = "Endpoints de gestion des personnes")
public class PersonController {

    private final PersonService personService;


}
