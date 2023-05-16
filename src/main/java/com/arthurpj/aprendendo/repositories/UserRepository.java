package com.arthurpj.aprendendo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurpj.aprendendo.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
