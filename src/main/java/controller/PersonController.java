package controller;

import Service.PersonService;
import entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public Person savePerson (@RequestBody Person person) {
        return personService.savePerson((person));
    }

    @GetMapping("/person")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> fetchPersonList() {
        return personService.fetchPersonList();
    }

    @PutMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson (@RequestBody Person person, @PathVariable("id") Long personId) {
        return personService.updatePerson(person,personId);
    }

    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePersonById (@PathVariable("id") Long personId) {
        personService.deletePersonById(personId);
        return "Deleted successfully";
    }
}
