package portal.career.translators;

import org.springframework.stereotype.Component;
import portal.career.entities.Person;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonTranslator
{
    public portal.career.models.Person Translate(@org.jetbrains.annotations.NotNull portal.career.entities.Person person)
    {
       return  portal.career.models.Person.builder()
               .id(person.getId() )
               .name(person.getName())
               .gender(person.getGender())
               .birthDate(person.getBirthDate())
               .created(person.getCreated())
               .description(person.getDescription())
               .build();
    }

    public portal.career.entities.Person Translate(@org.jetbrains.annotations.NotNull portal.career.models.Person person)
    {
        return  portal.career.entities.Person.builder()
                //.Id(person.getId() )
                .name(person.getName())
                .gender(person.getGender())
                .birthDate(person.getBirthDate())
                .created(person.getCreated() == null ? new Date() : person.getCreated())
                .description(person.getDescription())
                .build();
    }

    public List<portal.career.models.Person> Translate(List<Person> entities)
    {
        //List<portal.directory.entities.Person> persons=new ArrayList<>();
        var persons = entities.stream().map(entity -> Translate(entity)).collect(Collectors.toList());
        return persons;
    }



}
