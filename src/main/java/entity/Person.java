package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

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
    private UUID id;
    private String name;
    private String email;
}
