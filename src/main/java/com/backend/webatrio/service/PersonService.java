package com.backend.webatrio.service;

import com.backend.webatrio.dto.PersonDTO;
import com.backend.webatrio.entity.Person;
import com.backend.webatrio.exception.AgeTooHighException;
import com.backend.webatrio.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
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

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
