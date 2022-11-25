package com.example.services;

import java.util.List;

import com.example.model.Coffee;

public interface services {

	Iterable<Coffee> getAllCofeees();
	 List<Coffee> findByName(String name);

}