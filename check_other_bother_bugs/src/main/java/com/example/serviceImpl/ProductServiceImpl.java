package com.example.serviceImpl;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);

        return product;
    }

    public ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);

        return productDTO;
    }

    public List<ProductDTO> findAll(){
        List<Product> productList = this.productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList){
            productDTOList.add(this.toDTO(product));
        }
        return productDTOList;
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product= null;

        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("Did not find product id - " + id);
        }
        return product;
    }

    @Override
    public Optional<Product> findByDescription(String description){
        Optional<Product> result = Optional.ofNullable(productRepository.findByDescription(description));
        return result;
    }

    @Override
    public void create(ProductDTO productDTO) {
        if(productDTO!=null && productDTO.getId_product()==null){
            this.productRepository.save(this.toEntity(productDTO));
        }

    }

    @Override
    public void update(ProductDTO productDTO) {
        if(productDTO!=null && productDTO.getId_product()!=null){
            this.productRepository.save(this.toEntity(productDTO));
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id!=null){
            this.productRepository.deleteById(id);
        }
    }



}
