package com.projects.projectSpring.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projects.projectSpring.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @EmbeddedId
	 private OrderItemPK id = new OrderItemPK(); // Inicializa o id
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore	
    public Order getOrder() {
    	return id.getOrder();
    }
    
    public void setOrder(Order order) {
    	id.setOrder(order);
    }
    @JsonIgnore public Product getProduct() {
    	return id.getProduct();
    }
    
    public void setProduct(Product product) {
    	id.setProduct(product);
    }
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

	
}
