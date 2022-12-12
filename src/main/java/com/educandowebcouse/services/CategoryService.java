package com.educandowebcouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowebcouse.entities.Category;
import com.educandowebcouse.repositories.CategoryRepository;

 @Service   // classe de serviço do Spring é um componente
public class CategoryService {

	@Autowired // injeção de dependências
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	// Optional<Category> retorna um objeto
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); // retorna o objeto
	}
}
