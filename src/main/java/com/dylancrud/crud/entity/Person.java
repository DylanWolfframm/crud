package com.dylancrud.crud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
//Data is responsible for getters and setters
@Data
//Constructor with no args
@NoArgsConstructor
//Constructor with all args
@AllArgsConstructor
public class Person {
    @Id
    private Long id;
    private String name;
    private String email;
}
