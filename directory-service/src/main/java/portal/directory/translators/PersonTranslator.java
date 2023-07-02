package portal.directory.translators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

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
}
