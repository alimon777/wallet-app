package com.wallet.document.service;

import com.wallet.document.model.Person;
import com.wallet.document.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person not found with id " + id));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = getPersonById(id);
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setEmail(personDetails.getEmail());
        person.setPhoneNumber(personDetails.getPhoneNumber());
        person.setDateOfBirth(personDetails.getDateOfBirth());
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        Person person = getPersonById(id);
        personRepository.delete(person);
    }
}
