package com.projects.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.projectSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
