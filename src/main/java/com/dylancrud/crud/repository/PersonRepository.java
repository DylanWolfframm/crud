package com.dylancrud.crud.repository;


import com.dylancrud.crud.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
