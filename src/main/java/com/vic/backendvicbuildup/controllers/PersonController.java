package com.vic.backendvicbuildup.controllers;

import com.vic.backendvicbuildup.models.Person;
import com.vic.backendvicbuildup.services.PersonService;

import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.lang.annotation.Retention;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public ResponseEntity<?> getPersons() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getPersons());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getPersonById(id));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try {
            System.out.println("Persona: " + person);
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.savePerson(person));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        try {
            person.setPerson_Id(id);
            return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(person));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        } catch (HttpServerErrorException.InternalServerError e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(id));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
