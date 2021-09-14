package com.example.rest;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    private List<ProductDTO> findAll() {
        return this.productService.findAll();
    }

    @GetMapping(value = "{id_product}")
    private Product findById(@PathVariable final Long id_product) {
        Product product = productService.getById(id_product);
        if (product == null) {
            throw new RuntimeException(("Warehouse id not found -  " + id_product));
        }
        return product;
    }

    @RequestMapping(value = "/dp/{description_product}", method = RequestMethod.GET)
    private Optional<Product> findByDescription(@PathVariable("description_product") String description) {
        Optional<Product> product = productService.findByDescription(description);
        if (product == null) {
            throw new RuntimeException(("Warehouse description not found - " + description));
        }
        return product;
    }

    @PostMapping("/create")
    private void create(@RequestBody ProductDTO productDTO) {
        this.productService.create(productDTO);
    }

    @PutMapping("/update")
    private void update(@RequestBody ProductDTO productDTO) {
        this.productService.update(productDTO);
    }

    @DeleteMapping("delete/{id_product}")
    private void delete(@PathVariable final Long id_product) {
        this.productService.deleteById(id_product);
    }
}
