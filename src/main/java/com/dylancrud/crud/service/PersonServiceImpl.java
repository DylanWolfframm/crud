package com.dylancrud.crud.service;


import com.dylancrud.crud.entity.Person;
import com.dylancrud.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> fetchPersonList() {
        //Casting to a list, so we can send more than 1 person back.
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person person, Long personId) {
        Person personDB = personRepository.findById(personId).get();
        //Check if the object is not empty or is equal to the current state.
        if (Objects.nonNull(person.getName())&& !"".equalsIgnoreCase(person.getName()))
        {
            personDB.setName(person.getName());
        }

        if (Objects.nonNull(person.getEmail())&& !"".equalsIgnoreCase(person.getEmail()))
        {
            personDB.setEmail(person.getName());
        }
        return personRepository.save(personDB);
    }

    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);
    }
}
