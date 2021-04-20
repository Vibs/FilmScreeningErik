package com.example.demo.repository;

import com.example.demo.model.Authority;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer>
{
    
    // Optional<Authority> findByUsername(String username);
    
    
    
}
