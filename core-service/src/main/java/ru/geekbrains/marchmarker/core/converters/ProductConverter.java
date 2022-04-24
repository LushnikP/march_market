package ru.geekbrains.marchmarker.core.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.marchmarker.core.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public ProductDto entityToDto(Product p){
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setPrice(p.getPrice());
        productDto.setTitle(p.getTitle());
        productDto.setCategoryTitle(p.getCategory().getTitle());
        return productDto;
    }

    public List<ProductDto> allEntitiesToDto(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product p : products){
            ProductDto productDto = new ProductDto();
            productDto.setId(p.getId());
            productDto.setPrice(p.getPrice());
            productDto.setTitle(p.getTitle());
            productDto.setCategoryTitle(p.getCategory().getTitle());
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
