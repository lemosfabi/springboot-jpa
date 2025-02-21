package com.projects.projectSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.projectSpring.entities.Category;
import com.projects.projectSpring.services.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
	   Category obj = service.findById(id);
	   return ResponseEntity.ok().body(obj);
	}
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
