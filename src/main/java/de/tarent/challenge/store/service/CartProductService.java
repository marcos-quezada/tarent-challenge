package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.CartProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface CartProductService {

    CartProduct create(@NotNull(message = "The products for the cart cannot be null.") @Valid CartProduct cartProduct);
}
