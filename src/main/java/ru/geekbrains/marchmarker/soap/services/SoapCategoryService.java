package ru.geekbrains.marchmarker.soap.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marchmarker.entities.Category;
import ru.geekbrains.marchmarker.soap.categories.CategorySoap;
import ru.geekbrains.marchmarker.soap.repositories.SoapCategoryRepository;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SoapCategoryService {
    private final SoapCategoryRepository categoryRepository;

    public static final Function<Category, CategorySoap> functionEntityToSoap = ge -> {
        CategorySoap g = new CategorySoap();
        g.setTitle(ge.getTitle());
        ge.getProducts().stream().map(SoapProductService.functionEntityToSoap).forEach(s -> g.getProducts().add(s));
        return g;
    };

    public CategorySoap getByTitle(String title) {
        return categoryRepository.findByTitle(title).map(functionEntityToSoap).get();
    }
}
