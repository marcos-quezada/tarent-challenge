package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.Product;
import de.tarent.challenge.store.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService{

    private final ProductRepository productService;

    public ProductService(ProductRepository productService) {
        this.productService = productService;
    }

    public List<Product> retrieveAllProducts() {
        return productService.findAll();
    }

    public Product retrieveProductBySku(String sku) {
        return productService.findBySku(sku);
    }

    public Product save(Product product){return productService.save(product);}
}
