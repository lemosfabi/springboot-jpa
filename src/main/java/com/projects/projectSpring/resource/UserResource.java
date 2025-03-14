package com.projects.projectSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.projectSpring.entities.User;
import com.projects.projectSpring.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	   User obj = service.findById(id);
	   return ResponseEntity.ok().body(obj);
	}
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}
