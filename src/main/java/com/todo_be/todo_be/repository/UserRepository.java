package com.todo_be.todo_be.repository;

import com.todo_be.todo_be.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String token);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User findDataByEmail(String email);
}