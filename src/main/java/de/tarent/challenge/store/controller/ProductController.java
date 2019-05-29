package de.tarent.challenge.store.controller;

import de.tarent.challenge.store.exception.ResourceNotFoundException;
import de.tarent.challenge.store.model.Product;
import de.tarent.challenge.store.repository.ProductRepository;
import de.tarent.challenge.store.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> retrieveProducts() {
        return productService.retrieveAllProducts();
    }

    @GetMapping("/{sku}")
    public Product retrieveProductBySku(@PathVariable String sku) {
        return productService.retrieveProductBySku(sku);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){ return productService.save(product);}

    @PutMapping("update/{sku}")
    public Product updateProduct(@RequestBody Product product, @PathVariable String sku) {
        Product oldProduct = productService.retrieveProductBySku(sku);
        product.setId(oldProduct.getId());
        return productService.save(product);
    }

}
