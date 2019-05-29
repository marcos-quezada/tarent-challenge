package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.Product;
import de.tarent.challenge.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product retrieveProductBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public Product save(Product product){return productRepository.save(product);}
}
