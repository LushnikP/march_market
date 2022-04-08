package ru.geekbrains.marchmarker.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.dtos.ProductDto;
import ru.geekbrains.marchmarker.entities.Category;
import ru.geekbrains.marchmarker.entities.Product;
import ru.geekbrains.marchmarker.repositories.CategoryRepository;
import ru.geekbrains.marchmarker.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title){
        return categoryRepository.findByTitle(title);
    }
}
