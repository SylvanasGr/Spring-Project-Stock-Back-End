package com.example.rest;

import com.example.dto.ManagementDTO;
import com.example.dto.StockRecoveryDTO;
import com.example.entity.Management;
import com.example.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/management")
public class ManagementRestController {
    @Autowired
    private ManagementService managementService;

    @GetMapping("/all")
    private List<ManagementDTO> findAll(){
        return this.managementService.findAll();
    }

    @GetMapping(value = "{id_action}")
    private Management findById(@PathVariable final Long id_action){
        Management management = managementService.getById(id_action);
        if (management == null) {
            throw new RuntimeException(("Warehouse id not found -  " + id_action));
        }
        return management;
    }

//    @RequestMapping(value = "/eggrafes/{action_description}", method = RequestMethod.GET)
//    private List<Management> findByDescription(@PathVariable("action_description") String description) {
//        List<Management> management = managementService.findByDescription(description);
//        if (management== null) {
//            throw new RuntimeException(("Warehouse description not found - " + description));
//        }
//        return management;
//    }

    @GetMapping("/imports")
    public List<StockRecoveryDTO> findImports() {
    return this.managementService.findImports();
    }

    @GetMapping("/exports")
    public List<StockRecoveryDTO> findExports() {
        return this.managementService.findExports();
    }



    @PostMapping("/create")
    private void create(@RequestBody ManagementDTO managementDTO){
        this.managementService.create(managementDTO);
    }

    @PutMapping("/update")
    private void update(@RequestBody ManagementDTO managementDTO){
        this.managementService.update(managementDTO);
    }

    @DeleteMapping("delete/{id_action}")
    private void delete(@PathVariable final Long id_action){
        this.managementService.deleteById(id_action);
    }
}
