package com.backend.webatrio.controller;

import com.backend.webatrio.service.JobService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons/{personId}/jobs")
@RequiredArgsConstructor
@Tag(name = "Job", description = "Endpoints de gestion des emplois")
public class JobController {

    private final JobService jobService;
}
