package portal.finance.translators;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BankTranslator
{
    public portal.finance.models.Bank Translate(@org.jetbrains.annotations.NotNull portal.finance.entities.Bank entity)
    {
       return  portal.finance.models.Bank.builder()
               .id(entity.getId())
               .name(entity.getName())
               .pan(entity.getPAN())
               .tan(entity.getTAN())
               .created(entity.getCreated())
               .desc(entity.getDescription())
               .build();
    }

    public portal.finance.entities.Bank Translate(@org.jetbrains.annotations.NotNull portal.finance.models.Bank model)
    {
        return  portal.finance.entities.Bank.builder()
                //.Id(person.getId() )
                .name(model.getName())
                .pan(model.getPAN())
                .tan(model.getTAN())
                .created(model.getCreated() == null ? new Date() : model.getCreated())
                .desc(model.getDescription())
                .build();
    }
}
