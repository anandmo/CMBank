package com.cmbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmbank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
}