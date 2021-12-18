package Reto5Ciclo4.controller;

import Reto5Ciclo4.model.Clothe;
import Reto5Ciclo4.service.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ClotheController {
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference") String reference) {
        return clotheService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe) {
        return clotheService.save(clothe);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe clothe) {
        return clotheService.update(clothe);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Clothe> getByPrice(@PathVariable("price") double price){
        return clotheService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Clothe> getByDescriptionContains(@PathVariable("description") String description){
        return clotheService.getByDescriptionContains(description);
    }
}
