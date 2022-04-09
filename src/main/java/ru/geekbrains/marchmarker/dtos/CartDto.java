package ru.geekbrains.marchmarker.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.marchmarker.utils.CartItem;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {
    private List<CartItem> items;
    private BigDecimal totalPrice;
}
