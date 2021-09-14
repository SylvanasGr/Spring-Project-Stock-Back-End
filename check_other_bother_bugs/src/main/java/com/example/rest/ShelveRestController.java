package com.example.rest;

import com.example.dto.ShelveDTO;
import com.example.entity.Shelve;
import com.example.service.ShelveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("shelve")
public class ShelveRestController {

    @Autowired
    private ShelveService shelveService;

    @GetMapping("/all")
    private List<ShelveDTO> findAll() {
        return this.shelveService.findAll();
    }

    @GetMapping(value = "{id_shelve}")
    private Shelve findById(@PathVariable final Long id_shelve) {
        Shelve shelve = shelveService.getById(id_shelve);
        if (shelve == null) {
            throw new RuntimeException(("Warehouse id not found -  " + id_shelve));
        }
        return shelve;
    }

    @RequestMapping(value = "/dp/{description_shelve}", method = RequestMethod.GET)
    private Optional<Shelve> findByDescription(@PathVariable("description_shelve") String description) {
        Optional<Shelve> shelve = shelveService.findByDescription(description);
        if (shelve == null) {
            throw new RuntimeException(("Warehouse description not found - " + description));
        }
        return shelve;
    }

    @PostMapping("/create")
    private void create(@RequestBody ShelveDTO shelveDTO) {
        this.shelveService.create(shelveDTO);
    }

    @PutMapping("/update")
    private void update(@RequestBody ShelveDTO shelveDTO) {
        this.shelveService.update(shelveDTO);
    }

    @DeleteMapping("delete/{id_shelve}")
    private void delete(@PathVariable final Long id_shelve){
        this.shelveService.deleteById(id_shelve);
    }
}
