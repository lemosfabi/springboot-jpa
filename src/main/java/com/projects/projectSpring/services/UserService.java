package com.projects.projectSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projects.projectSpring.entities.User;
import com.projects.projectSpring.repositories.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj  = repository.findById(id);
		return obj.get();
	}

}
