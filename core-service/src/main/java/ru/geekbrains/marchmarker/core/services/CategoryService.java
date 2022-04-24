package ru.geekbrains.marchmarker.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.core.entities.Category;
import ru.geekbrains.marchmarker.core.repositories.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title){
        return categoryRepository.findByTitle(title);
    }
}
