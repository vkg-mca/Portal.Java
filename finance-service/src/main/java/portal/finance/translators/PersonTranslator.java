package portal.finance.translators;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class PersonTranslator
{
    public portal.finance.models.Person Translate(@org.jetbrains.annotations.NotNull portal.finance.entities.Person person)
    {
       return  portal.finance.models.Person.builder()
               .Id(person.getId() )
               .Name(person.getName())
               .Gender(person.getGender())
               .BirthDate(person.getBirthDate())
               .Created(person.getCreated())
               .Description(person.getDescription())
               .build();
    }

    public portal.finance.entities.Person Translate(@org.jetbrains.annotations.NotNull portal.finance.models.Person person)
    {
        return  portal.finance.entities.Person.builder()
                //.Id(person.getId() )
                .Name(person.getName())
                .Gender(person.getGender())
                .BirthDate(person.getBirthDate())
                .Created(person.getCreated() == null ? new Date() : person.getCreated())
                .Description(person.getDescription())
                .build();
    }
}
