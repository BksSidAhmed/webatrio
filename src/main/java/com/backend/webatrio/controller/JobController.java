package com.backend.webatrio.controller;

import com.backend.webatrio.dto.JobDTO;
import com.backend.webatrio.entity.Job;
import com.backend.webatrio.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@Tag(name = "Job", description = "Endpoints de gestion des emplois")
public class JobController {

    private final JobService jobService;

    @PostMapping("/{personId}")
    @Operation(summary = "Ajouter un emploi à une personne")
    @ApiResponse(responseCode = "200", description = "Emploi ajouté avec succès")
    public ResponseEntity<Job> addJobToPerson(@PathVariable Long personId, @RequestBody @Valid JobDTO jobDTO) {
        return ResponseEntity.ok(jobService.addJobToPerson(personId, jobDTO));
    }
}
