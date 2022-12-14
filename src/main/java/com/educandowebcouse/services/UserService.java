package com.educandowebcouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandowebcouse.entities.User;
import com.educandowebcouse.repositories.UserRepository;

 @Service   // classe de serviço do Spring é um componente
public class UserService {

	@Autowired // injeção de dependências
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// Optional<User> retorna um objeto
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // retorna o objeto
	}
	
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
