package ru.geekbrains.marchmarker.utils;

import lombok.Data;
import ru.geekbrains.marchmarker.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;

    public void add(Product p) {
        for (CartItem item : items){
            if (item.getProductId().equals(p.getId())){
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();
    }

    public void remove(Product p){
        for (CartItem item : items){
            if (item.getProductId().equals(p.getId())){
                item.decrementQuantity();
                recalculate();
                if(item.getQuantity() == 0){
                    items.remove(item);
                }
                return;
            }
        }
    }

    public void clear(){
        items.clear();
        totalPrice = BigDecimal.ZERO;
    }

    private void recalculate(){
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));

    }
}
