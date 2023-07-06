package portal.directory.translators;

import org.springframework.stereotype.Component;
import portal.directory.entities.Person;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonTranslator
{
    public portal.directory.models.Person Translate(@org.jetbrains.annotations.NotNull portal.directory.entities.Person person)
    {
       return  portal.directory.models.Person.builder()
               .Id(person.getId() )
               .Name(person.getName())
               .Gender(person.getGender())
               .BirthDate(person.getBirthDate())
               .Created(person.getCreated())
               .Description(person.getDescription())
               .build();
    }

    public portal.directory.entities.Person Translate(@org.jetbrains.annotations.NotNull portal.directory.models.Person person)
    {
        return  portal.directory.entities.Person.builder()
                //.Id(person.getId() )
                .Name(person.getName())
                .Gender(person.getGender())
                .BirthDate(person.getBirthDate())
                .Created(person.getCreated() == null ? new Date() : person.getCreated())
                .Description(person.getDescription())
                .build();
    }

    public List<portal.directory.models.Person> Translate(List<Person> entities)
    {
        //List<portal.directory.entities.Person> persons=new ArrayList<>();
        var persons = entities.stream().map(entity -> Translate(entity)).collect(Collectors.toList());
        return persons;
    }



}
