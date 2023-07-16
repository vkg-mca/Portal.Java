package portal.directory.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="Person")
@Entity
@Data
@Builder//Builder method implements
public class Person
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Character gender;
    private Date birthDate;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Date created ;
    private String description;
}
