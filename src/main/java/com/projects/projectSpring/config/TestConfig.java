package com.projects.projectSpring.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import com.projects.projectSpring.entities.User;
import com.projects.projectSpring.repositories.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	
	}
	

	
}
