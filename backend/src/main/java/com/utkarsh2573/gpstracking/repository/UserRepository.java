package com.utkarsh2573.gpstracking.repository;

import com.utkarsh2573.gpstracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
