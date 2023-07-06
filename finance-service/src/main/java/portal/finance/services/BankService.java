package portal.finance.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.finance.models.Bank;
import portal.finance.models.Person;
import portal.finance.repositories.BankRepository;
import portal.finance.repositories.FinanceRepository;
import portal.finance.repositories.PersonRepository;
import portal.finance.translators.BankTranslator;
import portal.finance.translators.PersonTranslator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankService
{
    //@Autowired private final FinanceRepository<Bank,Integer> _repo;
    @Autowired private final BankRepository _repo;

    @Autowired private BankTranslator _translator;

    @SneakyThrows
    public portal.finance.models.Bank Get(int id) {
        var entity = _repo.findById(id);
        return entity.map(e -> _translator.Translate(e)).orElse(null);
    }

    public List<portal.finance.models.Bank> Get() {
        var entities = _repo.findAll();
        var models = entities.stream().map(entity -> _translator.Translate(entity)).collect(Collectors.toList());

        return models;
    }

    public int Save(portal.finance.models.Bank model) {
        var entity = _translator.Translate(model);
        var saved = _repo.save(entity);
        return saved.getId() ;
    }

    public int Update(int pid,portal.finance.models.Bank model) {
        var existing_entity=_repo.getReferenceById(pid);
        existing_entity.setName(model.getName());
        var entity = _repo.save(existing_entity);
        log.info("Bank {} is saved",entity.getId());
        return entity.getId() ;
    }

    public Boolean Delete(int id) {
        _repo.deleteById(id);
        return true;
    }

    public List<Bank> Get(List<Integer> ids) {
        var entities = _repo.findAllById(ids);
        var models = entities.stream().map(entity -> _translator.Translate(entity)).collect(Collectors.toList());
        return models;
    }
}
