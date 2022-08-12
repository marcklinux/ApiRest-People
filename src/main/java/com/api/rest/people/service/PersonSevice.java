package com.api.rest.people.service;

import com.api.rest.people.dto.PersonDto;
import com.api.rest.people.model.Person;

import java.util.List;

public interface PersonSevice {

    PersonDto getPersonById(Long id);
    List<Person> getAllPerson();
    void savePerson(PersonDto personDto);
    void updatePerson(Long id,PersonDto personDto);
    void deletePersonById(Long id);

}
