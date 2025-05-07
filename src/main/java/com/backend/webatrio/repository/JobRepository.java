package com.backend.webatrio.repository;

import com.backend.webatrio.entity.Job;
import com.backend.webatrio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByPerson(Person person);

}
