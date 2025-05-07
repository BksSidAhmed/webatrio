package com.backend.webatrio.repository;

import com.backend.webatrio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // Utilisation de @Query pour rechercher les personnes ayant travaillé pour une entreprise donnée
    @Query("SELECT p FROM Person p JOIN p.jobs j WHERE j.company = :company")
    List<Person> findPeopleByCompany(@Param("company") String company);
}
