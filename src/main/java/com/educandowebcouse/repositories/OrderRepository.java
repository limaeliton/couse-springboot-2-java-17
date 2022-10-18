package com.educandowebcouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandowebcouse.entities.Order;
// a classe Repository salva os dados
// UserRepository é um objeto Repository que tem várias operações para trabalhar com o Order

public interface OrderRepository extends JpaRepository<Order, Long>{

	
	
}
