package com.backend.webatrio.service;

import com.backend.webatrio.dto.JobDTO;
import com.backend.webatrio.entity.Job;
import com.backend.webatrio.entity.Person;
import com.backend.webatrio.repository.JobRepository;
import com.backend.webatrio.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final PersonRepository personRepository;

    /**
     * Ajoute un emploi à une personne spécifiée par son identifiant.
     *
     * @param personId L'identifiant de la personne à laquelle l'emploi doit être ajouté.
     * @param jobDTO Les informations concernant l'emploi à ajouter sous forme de DTO.
     * @return L'emploi créé et sauvegardé dans la base de données.
     * @throws IllegalArgumentException Si la personne avec l'ID spécifié n'existe pas.
     */
    public Job addJobToPerson(Long personId, JobDTO jobDTO) {

        // Vérifier si la personne existe
        Optional<Person> personOpt = personRepository.findById(personId);
        if (personOpt.isEmpty()) {
            throw new IllegalArgumentException("Personne non trouvée");
        }
        Person person = personOpt.get();

        Job job = new Job();
        job.setCompany(jobDTO.getCompany());
        job.setPosition(jobDTO.getPosition());
        job.setStartDate(jobDTO.getStartDate());
        job.setEndDate(jobDTO.getEndDate());

        // Associer l'emploi à la personne
        job.setPerson(person);

        return jobRepository.save(job);
    }

}
