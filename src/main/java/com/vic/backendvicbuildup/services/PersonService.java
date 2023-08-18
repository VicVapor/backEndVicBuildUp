package com.vic.backendvicbuildup.services;

import com.vic.backendvicbuildup.models.Person;
import com.vic.backendvicbuildup.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public ArrayList<Person> getPersons() {
        return (ArrayList<Person>) personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) throws NoSuchElementException {
        Person personById = personRepository.findById(person.getPerson_Id()).get();
        System.out.println("Persona antigua: " + personById);
        personById.setEmail(person.getEmail());
        personById.setPerson_Password(person.getPerson_Password());
        personById.setFirst_Name(person.getFirst_Name());
        personById.setLast_Name(person.getLast_Name());
        personById.setAge(person.getAge());
        personById.setPhone(person.getPhone());
        System.out.println("Persona nueva: " + personById);
        return personRepository.save(personById);
    }

    public String deletePerson(int id) {
        Person personDeleted = personRepository.findById(id).get();
        personRepository.deleteById(id);
        return "Person\n" + personDeleted + "\nsuccessfully deleted";
    }

}
