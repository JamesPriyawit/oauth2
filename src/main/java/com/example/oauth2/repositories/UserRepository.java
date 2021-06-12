package com.example.oauth2.repositories;

import com.example.oauth2.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByUsername(String authenticate);

    User findOneById(Integer id);
}
