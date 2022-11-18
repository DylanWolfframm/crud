package com.dylancrud.crud.service;



import com.dylancrud.crud.entity.Person;

import java.util.List;

public interface PersonService {
    //Add person to the DB
    Person savePerson(Person person);

    //Get all people from the DB
    List<Person> fetchPersonList();

    //Update person from the DB
    Person updatePerson(Person person, Long personId);

    //Delete person from the DB
    void deletePersonById(Long personId);
}
