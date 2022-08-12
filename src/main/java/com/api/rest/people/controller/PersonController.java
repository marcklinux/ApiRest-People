package com.api.rest.people.controller;

import com.api.rest.people.dto.PersonDto;

import com.api.rest.people.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonSevice personSevice;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<?> findAllPerson(){
        response.clear();
        response.put("people",personSevice.getAllPerson());
        return new  ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person",personSevice.getPersonById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/new")
    public ResponseEntity<?> savePerson(@Valid @RequestBody PersonDto personDto){
        response.clear();
        personSevice.savePerson(personDto);
        response.put("message","save person successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        response.clear();
        personSevice.updatePerson(id,personDto);
        response.put("message","Person update successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Long id){
        response.clear();
        personSevice.deletePersonById(id);
        response.put("message","Person deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
