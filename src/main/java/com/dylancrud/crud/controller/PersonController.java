package com.dylancrud.crud.controller;


import com.dylancrud.crud.entity.Person;
import com.dylancrud.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
//CORS acceptance
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Person savePerson (@RequestBody Person person) {
        return personService.savePerson((person));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> fetchPersonList() {
        return personService.fetchPersonList();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson (@RequestBody Person person, @PathVariable("personId") Long personId) {
        return personService.updatePerson(person,personId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonById (@PathVariable Long personId) {
        System.out.println(personId);
        personService.deletePersonById(personId);
    }
}
