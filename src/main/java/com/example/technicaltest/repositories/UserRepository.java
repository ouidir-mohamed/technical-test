package com.example.technicaltest.repositories;

import com.example.technicaltest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
