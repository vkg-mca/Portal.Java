package portal.directory.translators;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeSetTranslator
{
    public portal.directory.models.CodeSet Translate(@org.jetbrains.annotations.NotNull portal.directory.entities.CodeSet entity)
    {
       return  portal.directory.models.CodeSet.builder()
               .Id(entity.getId() )
               .Category(entity.getCategory())
               .Code(entity.getCode())
               .Value(entity.getValue())
               .Created(entity.getCreated())
               .Description(entity.getDescription())
               .build();
    }

    public portal.directory.entities.CodeSet Translate(@org.jetbrains.annotations.NotNull portal.directory.models.CodeSet model)
    {
        return  portal.directory.entities.CodeSet.builder()
                .Category(model.getCategory())
                .Code(model.getCode())
                .Value(model.getValue())
                .Created(model.getCreated())
                .Description(model.getDescription())
                .build();
    }

    public List<portal.directory.models.CodeSet> Translate(List<portal.directory.entities.CodeSet> entities)
    {
        //List<portal.directory.entities.Person> persons=new ArrayList<>();
        var persons = entities.stream().map(entity -> Translate(entity)).collect(Collectors.toList());
        return persons;
    }



}
