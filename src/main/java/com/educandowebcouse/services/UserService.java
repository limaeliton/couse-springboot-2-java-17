package com.educandowebcouse.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandowebcouse.entities.User;
import com.educandowebcouse.repositories.UserRepository;
import com.educandowebcouse.services.exceptions.DatabaseException;
import com.educandowebcouse.services.exceptions.ResourceNotFoundException;

@Service // classe de serviço do Spring é um componente
public class UserService {

	@Autowired // injeção de dependências
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	// Optional<User> retorna um objeto
	// tenta dar o get se não tiver usuário lança exceção |orElseThrow(() -> new
	// ResourceNotFoundException(id))
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));// retorna o objeto
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
