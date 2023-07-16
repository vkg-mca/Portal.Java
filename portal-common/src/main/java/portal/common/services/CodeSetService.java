package portal.common.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.common.models.CodeSet;
import portal.common.repositories.CodeSetRepository;
import portal.common.translators.CodeSetTranslator;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Slf4j
public class CodeSetService
{
    @Autowired(required = true) private CodeSetRepository _repo;
    @Autowired(required = true) private CodeSetTranslator _translator;

    @SneakyThrows
    public CodeSet GetCodeSet(int id)
    {
        var entity = _repo.findById(id);
        return entity.map(_translator::Translate).orElse(null);
    }

    public CodeSet FindByCode(String code)
    {
        var entity = _repo.findByCode(code);
        return entity.map(_translator::Translate).orElse(null);
    }
    public CodeSet FindByCategoryAndCode(String category, String code)
    {
        var entity = _repo.findByCategoryAndCode(category,code);
        return entity.map(_translator::Translate).orElse(null);
    }

    public List<CodeSet> FindByCategory(String category)
    {
        var entities = _repo.findByCategory(category);
        var codeset = entities.stream().map(_translator::Translate).collect(Collectors.toList());

        return codeset;
    }
    
    public List<CodeSet> GetCodeSet()
    {
        var entities = _repo.findAll();
        var codeset = entities.stream().map(_translator::Translate).collect(Collectors.toList());

        return codeset;
    }


    public int SaveCodeSet(CodeSet codeset)
    {
        var entity = _translator.Translate(codeset);
        var saved = _repo.save(entity);
        return saved.getId() ;
    }

    public int UpdateCodeSet(int id,CodeSet codeSet)
    {
        var existing_entity=_repo.getReferenceById(id);
        existing_entity.setCategory(codeSet.getCategory());
        existing_entity.setCode(codeSet.getCode());
        existing_entity.setValue(codeSet.getValue());
        var entity = _repo.save(existing_entity);
        log.info("CodeSet {} is saved",entity.getId());
        return entity.getId() ;
    }

    public Boolean DeleteCodeSet(int id)
    {
        _repo.deleteById(id);
        return true;
    }
}
