package portal.directory.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portal.directory.models.Person;
import portal.directory.repositories.PersonRepository;
import portal.directory.translators.PersonTranslator;

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
    private final PersonTranslator _translator;

    @SneakyThrows
    public portal.directory.models.Person GetPerson(int pid)
    {
        var entity = _repo.findById(pid);
        return entity.map(_translator::Translate).orElse(null);
    }

    public List<Person> GetPerson()
    {
        //List<Person> persons;
        var entities = _repo.findAll();
        var persons = entities.stream().map(_translator::Translate).collect(Collectors.toList());

        return persons;
    }

//    public List<Person> GetPerson(Character gender)
//    {
//        //List<Person> persons;
//        var entities = _repo.findByGender(gender);
//        var persons = entities.stream().map(entity -> _translator.Translate(entity)).collect(Collectors.toList());
//        return persons;
//    }

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
