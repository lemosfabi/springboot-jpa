package com.projects.projectSpring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.projectSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
