package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, String> {
  
	 List<Coffee> findByName(String name);
}
