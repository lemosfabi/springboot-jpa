package com.projects.projectSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projects.projectSpring.entities.Category;
import com.projects.projectSpring.entities.Order;
import com.projects.projectSpring.entities.OrderItem;
import com.projects.projectSpring.entities.Product;
import com.projects.projectSpring.entities.User;
import com.projects.projectSpring.entities.enums.OrderStatus;
import com.projects.projectSpring.repositories.CategoryRepository;
import com.projects.projectSpring.repositories.OrderItemRepository;
import com.projects.projectSpring.repositories.OrderRepository;
import com.projects.projectSpring.repositories.ProductRepository;
import com.projects.projectSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
	private OrderRepository orderRepository;
    
    @Autowired
	private CategoryRepository categoryRepository;
    
    @Autowired
   	private OrderItemRepository orderItemRepository;
    
	@Override
	public void run(String... args) throws Exception {
		
		// Criando categorias
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		// Salvando categorias primeiro
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		// Criando produtos
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		// Associando categorias aos produtos
		p1.getCategories().add(cat2);
		p2.getCategories().addAll(Arrays.asList(cat1, cat3));
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		// Salvando produtos
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// Criando usuários
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

		// Salvando usuários
		userRepository.saveAll(Arrays.asList(u1, u2));

		// Criando pedidos
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		// Salvando pedidos
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		// Criando itens dos pedidos
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		// Salvando itens dos pedidos
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}
}
