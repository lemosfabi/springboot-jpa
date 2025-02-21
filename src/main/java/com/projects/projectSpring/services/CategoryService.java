package com.projects.projectSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projects.projectSpring.entities.Category;
import com.projects.projectSpring.repositories.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj  = repository.findById(id);
		return obj.get();
	}

}
