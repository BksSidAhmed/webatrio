package com.backend.webatrio.repository;

import com.backend.webatrio.entity.Job;
import com.backend.webatrio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByPerson(Person person);

//    /**
//     * Trouver tous les emplois d'une personne dans une plage de dates.
//     *
//     * @param personId  ID de la personne
//     * @param startDate Date de début de la plage
//     * @param endDate   Date de fin de la plage
//     * @return Liste des emplois correspondants
//     */
//    List<Job> findByPersonIdAndStartDateBetweenOrEndDateBetween(Long personId, LocalDate startDate, LocalDate endDate);

}
