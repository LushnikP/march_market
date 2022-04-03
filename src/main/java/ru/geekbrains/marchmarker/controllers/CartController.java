package ru.geekbrains.marchmarker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.marchmarker.entities.Product;
import ru.geekbrains.marchmarker.services.CartService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cartService.addToCart(id);
    }

    @GetMapping()
    public List<Product> getCart(){
        return cartService.getCard();
    }
}
