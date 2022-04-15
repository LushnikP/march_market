package ru.geekbrains.marchmarker.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.marchmarker.dtos.CartDto;
import ru.geekbrains.marchmarker.utils.Cart;

@Component
public class CartConverter {
    public CartDto cartToCartDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setItems(cart.getItems());
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }

}
