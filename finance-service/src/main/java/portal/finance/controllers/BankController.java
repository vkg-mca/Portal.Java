package portal.finance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import portal.finance.models.Bank;
import portal.finance.services.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController
{
    @Autowired
    private BankService _service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bank> Get()
    {
        return _service.Get();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bank Get(@PathVariable int id)
    {
        return _service.Get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int Save(@RequestBody Bank bank)
    {
        return _service.Save(bank);
    }

    @PutMapping("/{pid}")
    public int Update(@PathVariable int id, @RequestBody Bank bank)
    {
        return _service.Update(id, bank);
    }

    /**
     * @param id bankId
     * @return Boolean
     */
    @DeleteMapping("/{id}")
    public Boolean Delete(@PathVariable int id)
    {
        return _service.Delete(id);
    }
}
