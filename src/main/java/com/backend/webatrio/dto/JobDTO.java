package com.backend.webatrio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobDTO {

    private String company;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;
}