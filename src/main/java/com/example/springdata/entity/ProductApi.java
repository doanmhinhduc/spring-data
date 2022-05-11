package com.example.springdata.entity;

import com.example.springdata.entity.enums.Product;
import com.example.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductApi {

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit){
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product finById(@PathVariable String id){
        return productRepository.findById(id).get();

    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable String id, @RequestBody Product updateProduct){
        Product existing = productRepository.findById(id).get();
        existing.setName(updateProduct.getName());
        existing.setSlug(updateProduct.getSlug());
        existing.setPrice(updateProduct.getPrice());
        existing.setDescription(updateProduct.getDescription());
        productRepository.save(existing);
        return updateProduct ;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable String id) {
        productRepository.deleteById(id);
        return true;
    }

}
