package com.educandowebcouse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandowebcouse.entities.Category;
import com.educandowebcouse.entities.Order;
import com.educandowebcouse.entities.User;
import com.educandowebcouse.entities.enums.OrderStatus;
import com.educandowebcouse.repositories.CategoryRepository;
import com.educandowebcouse.repositories.OrderRepository;
import com.educandowebcouse.repositories.UserRepository;

@Configuration
@Profile("test") // configuração especifica para o perfil de teste, esta na
					// application.properties
public class TestConfig implements CommandLineRunner {
// CommandLineRunner executa quando o programa for iniciado
// serve para popular o banco de dados com alguns objetos, e fazer a injeção de depêndencias no UserRepository

	@Autowired // faz a injeção de dependências
	private UserRepository userRepository;
	
	@Autowired // faz a injeção de dependências
	private OrderRepository orderRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
// null pois o id vai ser gerado pelo banco de dados	
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		
// salva uma lista de objetos no banco
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
