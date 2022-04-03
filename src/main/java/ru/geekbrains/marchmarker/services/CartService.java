package ru.geekbrains.marchmarker.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.entities.Product;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;

    @Getter
    private final List<Product> card = new ArrayList<>();

    public void addToCart(Long id) {
        card.add(productService.findById(id));
        System.out.println(card);
    }


}
