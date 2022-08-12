package com.api.rest.people.service.impl;

import com.api.rest.people.exception.NotFoundException;
import com.api.rest.people.model.Person;
import com.api.rest.people.repository.PersonRepository;
import com.api.rest.people.service.PersonSevice;
import com.api.rest.people.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class PersonServiceImpl implements PersonSevice {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil.getMessage("notFound",null, Locale.getDefault()))
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
                () -> new NotFoundException(messageUtil.getMessage("notFound",null, Locale.getDefault()))
        );

        person1.setName(person.getName());
        person1.setLastName(person.getLastName());
        personRepository.save(person1);
    }

    @Override
    public void deletePersonById(Long id) {
        Person person1 = personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil.getMessage("notFound",null, Locale.getDefault()))
        );
        personRepository.deleteById(id);
    }
}
