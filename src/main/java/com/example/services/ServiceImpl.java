package com.example.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Coffee;
import com.example.repository.CoffeeRepository;
@Service
public class ServiceImpl implements services {
	private CoffeeRepository coffeeRepository;

	public ServiceImpl(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
		System.out.println(this.getClass().getName());

	}

	@Override
	public Iterable<Coffee> getAllCofeees() {
		return coffeeRepository.findAll();
	}
	
	public Optional<Coffee> getOneCoffeeById(@PathVariable String id){
		return coffeeRepository.findById(id);
	}

	@Override
	public List<Coffee> findByName(String name) {
		// TODO Auto-generated method stub
		return coffeeRepository.findByName(name);
	}
}
