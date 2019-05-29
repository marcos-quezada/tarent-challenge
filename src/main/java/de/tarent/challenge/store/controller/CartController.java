package de.tarent.challenge.store.controller;

import de.tarent.challenge.store.dto.CartProductDto;
import de.tarent.challenge.store.exception.ResourceNotFoundException;
import de.tarent.challenge.store.model.CartProduct;
import de.tarent.challenge.store.model.CartStatus;
import de.tarent.challenge.store.model.ShoppingCart;
import de.tarent.challenge.store.service.CartProductService;
import de.tarent.challenge.store.service.CartService;
import de.tarent.challenge.store.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/cart")
public class CartController {

    ProductService productService;
    CartService cartService;
    CartProductService cartProductService;

    public CartController(ProductService productService, CartService cartService, CartProductService cartProductService) {
        this.productService = productService;
        this.cartService = cartService;
        this.cartProductService = cartProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull
    Iterable<ShoppingCart> list() {
        return this.cartService.getAllCarts();
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody CartForm form) {
        List<CartProductDto> formDtos = form.getProductCarts();
        validateProductsExistence(formDtos);
        ShoppingCart cart = new ShoppingCart();
        cart.setStatus(CartStatus.PAID.name());
        cart = this.cartService.create(cart);

        List<CartProduct> cartProducts = new ArrayList<>();
        for (CartProductDto dto : formDtos) {
            cartProducts.add(cartProductService.create(new CartProduct(cart, productService.retrieveProductBySku(dto
                    .getProduct()
                    .getSku()), dto.getQuantity())));
        }

        cart.setCartProducts(cartProducts);

        this.cartService.update(cart);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/carts/{id}")
                .buildAndExpand(cart.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(cart, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<CartProductDto> cartProducts) {
        List<CartProductDto> list = cartProducts
                .stream()
                .filter(op -> Objects.isNull(productService.retrieveProductBySku(op
                        .getProduct()
                        .getSku())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class CartForm {

        private List<CartProductDto> productCarts;

        public List<CartProductDto> getProductCarts() {
            return productCarts;
        }

        public void setProductCarts(List<CartProductDto> productCarts) {
            this.productCarts = productCarts;
        }
    }


}
