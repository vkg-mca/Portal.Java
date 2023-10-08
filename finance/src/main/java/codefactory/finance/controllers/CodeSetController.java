package codefactory.finance.controllers;

import codefactory.finance.services.CodeSetService;
import codefactory.model.CodeSet;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/codeset")
@AllArgsConstructor
public class CodeSetController
{
    @Autowired(required = true)
    private CodeSetService _service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CodeSet> GetCodeSet()
    {
        return _service.GetCodeSet();
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<CodeSet> FindByCategory(@PathVariable String category) { return _service.FindByCategory(category); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CodeSet GetCodeSet(@PathVariable int id)
    {
        return _service.GetCodeSet(id);
    }

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public List<CodeSet> FindByCode(@PathVariable String code) { return _service.FindByCode(code); }

    @GetMapping("/category-and-code/{category}/{code}")
    @ResponseStatus(HttpStatus.OK)
    public CodeSet FindByCategoryAndCode(@PathVariable String category, @PathVariable String code) { return _service.FindByCategoryAndCode(category,code); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int SaveCodeSet(@RequestBody CodeSet codeset)
    {
        return _service.SaveCodeSet(codeset);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int UpdateCodeSet(@PathVariable int id, @RequestBody CodeSet codeset) { return _service.UpdateCodeSet(id, codeset); }

    @DeleteMapping("/{id}")
    public Boolean DeleteCodeSet(@PathVariable int id)
    {
        return _service.DeleteCodeSet(id);
    }
}
