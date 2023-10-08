package codefactory.finance.translators;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BankTranslator
{
    public codefactory.finance.models.Bank Translate(@org.jetbrains.annotations.NotNull codefactory.finance.entities.Bank entity)
    {
       return  codefactory.finance.models.Bank.builder()
               .id(entity.getId())
               .name(entity.getName())
               .pan(entity.getPAN())
               .tan(entity.getTAN())
               .created(entity.getCreated())
               .desc(entity.getDescription())
               .build();
    }

    public codefactory.finance.entities.Bank Translate(@org.jetbrains.annotations.NotNull codefactory.finance.models.Bank model)
    {
        return  codefactory.finance.entities.Bank.builder()
                //.Id(person.getId() )
                .name(model.getName())
                .pan(model.getPAN())
                .tan(model.getTAN())
                .created(model.getCreated() == null ? new Date() : model.getCreated())
                .desc(model.getDescription())
                .build();
    }
}
