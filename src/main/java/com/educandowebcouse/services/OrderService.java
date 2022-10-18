package com.educandowebcouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowebcouse.entities.Order;
import com.educandowebcouse.repositories.OrderRepository;

 @Service   // classe de serviço do Spring é um componente
public class OrderService {

	@Autowired // injeção de dependências
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	// Optional<Order> retorna um objeto
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // retorna o objeto
	}
}
