package ru.geekbrains.marchmarker.core.soap.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.core.entities.Product;
import ru.geekbrains.marchmarker.core.soap.repositories.SoapProductRepository;
import ru.geekbrains.marchmarker.core.soap.products.ProductSoap;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoapProductService {
    private final SoapProductRepository productRepository;

    public static final Function<Product, ProductSoap> functionEntityToSoap = se -> {
        ProductSoap p = new ProductSoap();
        p.setId(se.getId());
        p.setTitle(se.getTitle());
        p.setPrice(se.getPrice());
        p.setCategoryTitle(se.getCategory().getTitle());
        return p;
    };

    public List<ProductSoap> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public ProductSoap getById(Long id) {
        return productRepository.findById(id).map(functionEntityToSoap).get();
    }
}