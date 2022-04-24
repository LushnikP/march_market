package ru.geekbrains.marchmarker.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.march.market.api.ProductDto;
import ru.geekbrains.marchmarker.core.converters.ProductConverter;
import ru.geekbrains.marchmarker.core.exceptions.ResourceNotFoundException;
import ru.geekbrains.marchmarker.core.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;


    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productConverter.allEntitiesToDto(productService.findAll());
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productConverter.entityToDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + id + " не найден")));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody ProductDto productDto){
        productService.createNewProductDto(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
