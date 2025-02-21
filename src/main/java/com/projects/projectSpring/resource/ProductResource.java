package com.projects.projectSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.projectSpring.entities.Product;
import com.projects.projectSpring.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
	   Product obj = service.findById(id);
	   return ResponseEntity.ok().body(obj);
	}
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
