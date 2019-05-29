package de.tarent.challenge.store.service;

import de.tarent.challenge.store.model.CartProduct;
import de.tarent.challenge.store.repository.CartProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartProductServiceImpl implements CartProductService {

    private CartProductRepository cartProductRepository;

    public CartProductServiceImpl(CartProductRepository cartProductRepository){
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CartProduct create(CartProduct cartProduct) {
        return this.cartProductRepository.save(cartProduct);
    }
}
