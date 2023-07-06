package portal.finance.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import portal.finance.models.Bank;
import portal.finance.services.BankService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/bank")
public class BankController
{
    @Autowired private BankService _service;
    private static final Logger logger = LoggerFactory.getLogger(BankController.class);


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

        logger.info("{}/{} called", "/api/bank",id);
        return _service.Get(id);
    }

    @GetMapping("/withids")
    @ResponseStatus(HttpStatus.OK)
    public List<Bank> Get(@RequestParam List<Integer> ids)
    {

        logger.info("{}/{} called", "/api/bank",ids);
        return _service.Get(ids);
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
