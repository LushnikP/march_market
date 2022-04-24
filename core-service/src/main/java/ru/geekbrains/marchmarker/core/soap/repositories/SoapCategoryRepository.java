package ru.geekbrains.marchmarker.core.soap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.marchmarker.core.entities.Category;

import java.util.Optional;

public interface SoapCategoryRepository extends JpaRepository<Category, Long> {
    @Query("select g from Category g where g.title = ?1")
    Optional<Category> findByTitle(String title);
}
