package portal.finance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import portal.finance.models.Person;
import portal.finance.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController
{
    @Autowired
    private PersonService _service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> GetPerson()
    {
        return _service.GetPerson();
    }

    @GetMapping("/{pid}")
    @ResponseStatus(HttpStatus.OK)
    public Person GetPerson(@PathVariable int pid)
    {
        return _service.GetPerson(pid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int SavePerson(@RequestBody Person person)
    {
        return _service.SavePerson(person);
    }

    @PutMapping("/{pid}")
    public int UpdatePerson(@PathVariable int pid, @RequestBody Person person)
    {
        return _service.UpdatePerson(pid, person);
    }

    /**
     * @param pid personId
     * @return Boolean
     */
    @DeleteMapping("/{pid}")
    public Boolean DeletePerson(@PathVariable int pid)
    {
        return _service.DeletePerson(pid);
    }
}
