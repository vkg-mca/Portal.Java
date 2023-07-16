//package portal.directory.services;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import portal.directory.models.CodeSet;
//import portal.directory.models.Person;
//import portal.directory.repositories.CodeSetRepository;
//import portal.directory.repositories.PersonRepository;
//import portal.directory.translators.CodeSetTranslator;
//import portal.directory.translators.PersonTranslator;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CodeSetService
//{
//    @Autowired private final CodeSetRepository _repo;
//    @Autowired private final CodeSetTranslator _translator;
//
//    @SneakyThrows
//    public CodeSet GetCodeSet(int pid)
//    {
//        var entity = _repo.findById(pid);
//        return entity.map(_translator::Translate).orElse(null);
//    }
//
//    public List<CodeSet> GetCodeSet()
//    {
//        var entities = _repo.findAll();
//        var codeset = entities.stream().map(_translator::Translate).collect(Collectors.toList());
//
//        return codeset;
//    }
//
//    public int SaveCodeSet(CodeSet codeset)
//    {
//        var entity = _translator.Translate(codeset);
//        var saved = _repo.save(entity);
//        return saved.getId() ;
//    }
//
//    public int UpdateCodeSet(int cid,CodeSet codeSet)
//    {
//        var existing_entity=_repo.getReferenceById(cid);
//        existing_entity.setCategory(codeSet.getCategory());
//        existing_entity.setCode(codeSet.getCode());
//        existing_entity.setValue(codeSet.getValue());
//        var entity = _repo.save(existing_entity);
//        log.info("CodeSet {} is saved",entity.getId());
//        return entity.getId() ;
//    }
//
//    public Boolean DeleteCodeSet(int pid)
//    {
//        _repo.deleteById(pid);
//        return true;
//    }
//}
