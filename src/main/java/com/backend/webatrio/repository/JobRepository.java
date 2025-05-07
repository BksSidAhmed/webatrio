package com.backend.webatrio.repository;

import com.backend.webatrio.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
