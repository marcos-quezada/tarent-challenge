package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.ShoppingCart;
import de.tarent.challenge.store.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class CartServiceImpl implements CartService{

    private ShoppingCartRepository cartRepository;

    public CartServiceImpl(ShoppingCartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public Iterable<ShoppingCart> getAllCarts() {
        return this.cartRepository.findAll();
    }

    @Override
    public ShoppingCart create(ShoppingCart cart) {
        cart.setDateCreated(LocalDate.now());

        return this.cartRepository.save(cart);
    }

    @Override
    public void update(ShoppingCart cart) {
        this.cartRepository.save(cart);
    }
}
