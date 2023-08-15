package com.example.picpay.domain.repository;

import com.example.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> userFindByDocument(String document);
    Optional<User> userFindById(Long id);
}
