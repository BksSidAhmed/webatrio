package com.backend.webatrio.service;

import com.backend.webatrio.dto.JobDTO;
import com.backend.webatrio.dto.PersonDTO;
import com.backend.webatrio.dto.PersonWithJobDTO;
import com.backend.webatrio.entity.Job;
import com.backend.webatrio.entity.Person;
import com.backend.webatrio.exception.AgeTooHighException;
import com.backend.webatrio.repository.JobRepository;
import com.backend.webatrio.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final JobRepository jobRepository;

    /**
     * Crée une nouvelle personne à partir des informations fournies dans le DTO.
     *
     * @param personDTO Le DTO contenant les informations nécessaires pour créer une nouvelle personne.
     * @return La personne créée et sauvegardée dans la base de données.
     * @throws AgeTooHighException Si l'âge de la personne est supérieur à 150 ans.
     */
    public Person createPerson(PersonDTO personDTO) {

        if (calculateAge(personDTO.getBirthDate()) > 150) {
            throw new AgeTooHighException("La personne a plus de 150 ans.");
        }

        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setBirthDate(personDTO.getBirthDate());

        return personRepository.save(person);
    }

    /**
     * Récupère toutes les personnes triées par ordre alphabétique, avec leur âge et leurs emplois actuels.
     *
     * @return Liste des personnes avec leurs informations.
     */
    public List<PersonWithJobDTO> getAllPersonsWithCurrentJobs() {
        List<Person> people = personRepository.findAll();

        return people.stream()
                .sorted((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .map(person -> {
                    PersonWithJobDTO personWithJobDTO = new PersonWithJobDTO();
                    personWithJobDTO.setFirstName(person.getFirstName());
                    personWithJobDTO.setLastName(person.getLastName());
                    personWithJobDTO.setAge(calculateAge(person.getBirthDate()));
                    personWithJobDTO.setCurrentJobs(getCurrentJobsForPerson(person));

                    return personWithJobDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * Récupère les emplois actuels d'une personne.
     *
     * @param person La personne pour laquelle les emplois sont recherchés.
     * @return Liste des emplois actuels de la personne.
     */
    private List<JobDTO> getCurrentJobsForPerson(Person person) {
        List<Job> jobs = jobRepository.findByPerson(person);

        return jobs.stream()
                .map(job -> {
                    JobDTO jobDTO = new JobDTO();
                    jobDTO.setCompany(job.getCompany());
                    jobDTO.setPosition(job.getPosition());
                    jobDTO.setStartDate(job.getStartDate());
                    jobDTO.setEndDate(job.getEndDate());
                    return jobDTO;
                })
                .collect(Collectors.toList());
    }


    /**
     * Récupère toutes les personnes ayant travaillé pour une entreprise donnée.
     *
     * @param company Le nom de l'entreprise pour laquelle nous cherchons les employés.
     * @return Une liste de personnes ayant travaillé pour l'entreprise donnée.
     */
    public List<Person> getPeopleByCompany(String company) {
        return personRepository.findPeopleByCompany(company);
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
