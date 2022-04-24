package ru.geekbrains.marchmarker.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.marchmarker.core.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
