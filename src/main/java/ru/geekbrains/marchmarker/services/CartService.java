package ru.geekbrains.marchmarker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.entities.Product;
import ru.geekbrains.marchmarker.exceptions.ResourceNotFoundException;
import ru.geekbrains.marchmarker.utils.Cart;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart cart;

    @PostConstruct
    public void init(){
        cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    public void clearCart(){
        cart.clear();
    }

    public Cart getCurrentCart(){
        return cart;
    }

    public void addToCart(Long productId){
        Product p = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + productId + " не найден"));
        cart.add(p);
    }

    public void deleteById(Long productId) {
        Product p = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + productId + " не найден"));
        cart.remove(p);
    }
}
