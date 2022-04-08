package ru.geekbrains.marchmarker.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marchmarker.converters.ProductConverter;
import ru.geekbrains.marchmarker.dtos.ProductDto;
import ru.geekbrains.marchmarker.entities.Product;
import ru.geekbrains.marchmarker.exceptions.AppError;
import ru.geekbrains.marchmarker.exceptions.ResourceNotFoundException;
import ru.geekbrains.marchmarker.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;


    @GetMapping
    public List<ProductDto> getAllProducts(){
        //return productService.findAll();
        return productConverter.allEntitiesToDto(productService.findAll());
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
//        Optional<Product> p = productService.findById(id);
//        if (p.isPresent()){
//            return new ResponseEntity<>(productConverter.entityToDto(p.get()), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new AppError("RESOURCE_NOT_FOUND", "Продукт с id: " + id + " не найден" ), HttpStatus.NOT_FOUND);
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
