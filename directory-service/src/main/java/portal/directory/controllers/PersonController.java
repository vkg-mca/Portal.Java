package portal.directory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import portal.directory.models.Person;
import portal.directory.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/directory")
public class PersonController
{
    @Autowired
    private PersonService _service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> GetPerson() { return _service.GetPerson(); }

    @GetMapping("/{pid}")
    @ResponseStatus(HttpStatus.OK)
    public Person GetPerson(@PathVariable int pid)
    {
        return _service.GetPerson(pid);
    }

    @GetMapping("/gender/{gender}")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> GetPerson(@PathVariable Character gender)   {   return _service.GetPerson(gender);  }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int SavePerson(@RequestBody Person person)
    {
        return _service.SavePerson(person);
    }

    @PutMapping("/{pid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int UpdatePerson(@PathVariable int pid, @RequestBody Person person) { return _service.UpdatePerson(pid, person); }

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
