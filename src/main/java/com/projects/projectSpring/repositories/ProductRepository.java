package com.projects.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.projectSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
