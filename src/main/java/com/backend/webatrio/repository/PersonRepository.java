package com.backend.webatrio.repository;

import com.backend.webatrio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
