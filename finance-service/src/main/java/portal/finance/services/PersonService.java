package portal.finance.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.finance.models.Person;
import portal.finance.repositories.PersonRepository;
import portal.finance.translators.PersonTranslator;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService
{
@Autowired
    private final PersonRepository _repo;
    @Autowired
    private PersonTranslator _translator;

    @SneakyThrows
    public portal.finance.models.Person GetPerson(int pid)
    {
        var entity = _repo.findById(pid);
        return entity.map(person -> _translator.Translate(person)).orElse(null);
    }

    public List<Person> GetPerson()
    {
        List<Person> persons;
        var entities = _repo.findAll();
        persons = entities.stream().map(entity -> _translator.Translate(entity)).collect(Collectors.toList());

        return persons;
    }

    public int SavePerson(Person person)
    {
        var entity = _translator.Translate(person);
        var saved = _repo.save(entity);
        return saved.getId() ;
    }

    public int UpdatePerson(int pid,Person person)
    {
        var existing_entity=_repo.getReferenceById(pid);
        existing_entity.setName(person.getName());
        existing_entity.setGender(person.getGender());
        existing_entity.setBirthDate(person.getBirthDate());
        var entity = _repo.save(existing_entity);
        log.info("Person {} is saved",entity.getId());
        return entity.getId() ;
    }

    public Boolean DeletePerson(int pid)
    {
        _repo.deleteById(pid);
        return true;
    }
}
