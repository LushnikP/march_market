package ru.geekbrains.marchmarker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marchmarker.converters.ProductConverter;
import ru.geekbrains.marchmarker.dtos.ProductDto;
import ru.geekbrains.marchmarker.exceptions.ResourceNotFoundException;
import ru.geekbrains.marchmarker.services.CartService;
import ru.geekbrains.marchmarker.services.ProductService;
import ru.geekbrains.marchmarker.utils.Cart;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Cart getCurrentCart(){
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId){
        cartService.addToCart(productId);
    }
}
