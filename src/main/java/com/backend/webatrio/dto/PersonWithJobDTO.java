package com.backend.webatrio.dto;

import lombok.Data;

import java.util.List;
@Data
public class PersonWithJobDTO {

    private String firstName;
    private String lastName;
    private int age;
    private List<JobDTO> currentJobs;
}
