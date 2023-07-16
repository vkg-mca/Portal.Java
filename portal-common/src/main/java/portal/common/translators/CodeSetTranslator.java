package portal.common.translators;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeSetTranslator
{
    public portal.common.models.CodeSet Translate(@org.jetbrains.annotations.NotNull portal.common.entities.CodeSet entity)
    {
       return  portal.common.models.CodeSet.builder()
               .id(entity.getId() )
               .category(entity.getCategory())
               .code(entity.getCode())
               .value(entity.getValue())
               .created(entity.getCreated())
               .description(entity.getDescription())
               .build();
    }

    public portal.common.entities.CodeSet Translate(@org.jetbrains.annotations.NotNull portal.common.models.CodeSet model)
    {
        return  portal.common.entities.CodeSet.builder()
                .category(model.getCategory())
                .code(model.getCode())
                .value(model.getValue())
                .created(model.getCreated())
                .description(model.getDescription())
                .build();
    }

    public List<portal.common.models.CodeSet> Translate(List<portal.common.entities.CodeSet> entities)
    {
        //List<portal.directory.entities.Person> persons=new ArrayList<>();
        var persons = entities.stream().map(entity -> Translate(entity)).collect(Collectors.toList());
        return persons;
    }



}
