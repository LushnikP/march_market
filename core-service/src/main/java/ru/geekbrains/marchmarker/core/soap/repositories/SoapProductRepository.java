package ru.geekbrains.marchmarker.core.soap.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marchmarker.core.entities.Product;

import java.util.Optional;

@Repository
public interface SoapProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
