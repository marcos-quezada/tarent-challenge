package de.tarent.challenge.store.repository;

import de.tarent.challenge.store.model.CartProduct;
import de.tarent.challenge.store.model.CartProductPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductPk> {
}
