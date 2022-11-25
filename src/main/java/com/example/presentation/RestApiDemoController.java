package com.example.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coffee;
import com.example.repository.CoffeeRepository;
import com.example.services.ServiceImpl;



@RestController
//@RequestMapping("/coffees")
public class RestApiDemoController {
	private  CoffeeRepository coffeeRepository ;
	private ServiceImpl serviceImpl;

	public RestApiDemoController(CoffeeRepository coffeeRepository, ServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
		this.coffeeRepository = coffeeRepository ;
		
	
		coffeeRepository.saveAll(List.of(
				new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareno"),
				new Coffee("Café tres Pontas")
				));
	}
	
	@GetMapping("/coffees")
	Iterable<Coffee> getCoffees() {
		return serviceImpl.getAllCofeees();

	}

	
	@GetMapping("/coffees/{id}")
	Optional<Coffee>getCoffeeById(@PathVariable String id){
		return serviceImpl.getOneCoffeeById(id);
	}
	
	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		return coffeeRepository.save(coffee);
	}
	@PutMapping("/coffees/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id,
			                         @RequestBody Coffee coffee ){
		
		return (coffeeRepository.existsById(id))
				? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
				: new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);		
	}
	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffeeRepository.deleteById(id);
		
	}
	
	@GetMapping("/coffees/name/{name}")
	Iterable<Coffee> getByName(@PathVariable  String name) {
		return serviceImpl.findByName(name);

	}
	}
	

