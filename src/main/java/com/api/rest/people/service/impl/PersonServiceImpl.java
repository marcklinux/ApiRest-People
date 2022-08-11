package com.api.rest.people.service.impl;

import com.api.rest.people.exception.NotFoundException;
import com.api.rest.people.model.Person;
import com.api.rest.people.repository.PersonRepository;
import com.api.rest.people.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonSevice {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Person Not Found")
        );
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();


    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person Not Found")
        );

        person1.setName(person.getName());
        person1.setLastName(person.getLastName());
        personRepository.save(person1);
    }

    @Override
    public void deletePersonById(Long id) {
        Person person1 = personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Person Not Found")
        );
        personRepository.deleteById(id);
    }
}
