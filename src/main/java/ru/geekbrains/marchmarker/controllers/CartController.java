package ru.geekbrains.marchmarker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marchmarker.converters.CartConverter;
import ru.geekbrains.marchmarker.dtos.CartDto;
import ru.geekbrains.marchmarker.services.CartService;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping
    public CartDto getCurrentCart(){
        return cartConverter.cartToCartDto(cartService.getCurrentCart());
    }

    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId){
        cartService.addToCart(productId);
    }

    @DeleteMapping
    public void clearCart(){
        cartService.clearCart();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
