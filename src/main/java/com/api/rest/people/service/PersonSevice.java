package com.api.rest.people.service;

import com.api.rest.people.model.Person;

import java.util.List;

public interface PersonSevice {

    Person getPersonById(Long id);
    List<Person> getAllPerson();
    void savePerson(Person person);
    void updatePerson(Long id,Person person);
    void deletePersonById(Long id);

}
