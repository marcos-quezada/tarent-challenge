package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.ShoppingCart;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CartService {
    @NotNull
    Iterable<ShoppingCart> getAllCarts();

    ShoppingCart create(@NotNull(message = "The cart cannot be null.") @Valid ShoppingCart cart);

    void update(@NotNull(message = "The cart cannot be null.") @Valid ShoppingCart cart);
}
