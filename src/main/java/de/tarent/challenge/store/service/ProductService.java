package de.tarent.challenge.store.service;


import de.tarent.challenge.store.model.Product;
import de.tarent.challenge.store.repository.ProductRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ProductService{
    @NotNull
    List<Product> retrieveAllProducts();

    Product retrieveProductBySku(@NotNull @NotEmpty(message = "Invalid product SKU.") String sku);

    Product save(Product product);
}
