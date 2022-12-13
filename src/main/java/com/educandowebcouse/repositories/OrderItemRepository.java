package com.educandowebcouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowebcouse.entities.OrderItem;
// a classe Repository salva os dados
// UserRepository é um objeto Repository que tem várias operações para trabalhar com o User

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
	
}
