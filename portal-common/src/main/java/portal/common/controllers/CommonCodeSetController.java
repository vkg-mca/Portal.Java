//package portal.common.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import portal.common.models.CodeSet;
//import portal.common.services.CodeSetService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/codeset")
////@AllArgsConstructor
//public class CommonCodeSetController
//{
//    @Autowired
//    private CodeSetService _service;
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<CodeSet> GetCodeSet()
//    {
//        return _service.GetCodeSet();
//    }
//
//    @GetMapping("/{cid}")
//    @ResponseStatus(HttpStatus.OK)
//    public CodeSet GetCodeSet(@PathVariable int cid)
//    {
//        return _service.GetCodeSet(cid);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public int SaveCodeSet(@RequestBody CodeSet codeset)
//    {
//        return _service.SaveCodeSet(codeset);
//    }
//
//    @PutMapping("/{cid}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public int UpdateCodeSet(@PathVariable int cid, @RequestBody CodeSet codeset) { return _service.UpdateCodeSet(cid, codeset); }
//
//    /**
//     * @param cid codesetId
//     * @return Boolean
//     */
//    @DeleteMapping("/{cid}")
//    public Boolean DeleteCodeSet(@PathVariable int cid)
//    {
//        return _service.DeleteCodeSet(cid);
//    }
//}
