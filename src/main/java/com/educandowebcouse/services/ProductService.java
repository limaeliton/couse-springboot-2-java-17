package com.educandowebcouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowebcouse.entities.Product;
import com.educandowebcouse.repositories.ProductRepository;

 @Service   // classe de serviço do Spring é um componente
public class ProductService {

	@Autowired // injeção de dependências
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	// Optional<Product> retorna um objeto
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); // retorna o objeto
	}
}
