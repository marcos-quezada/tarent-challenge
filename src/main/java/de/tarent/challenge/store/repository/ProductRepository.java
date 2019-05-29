package de.tarent.challenge.store.repository;

import de.tarent.challenge.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySku(String sku);

}
