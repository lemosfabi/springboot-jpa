package com.projects.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.projectSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
