package com.projects.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.projectSpring.entities.OrderItem;
import com.projects.projectSpring.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
