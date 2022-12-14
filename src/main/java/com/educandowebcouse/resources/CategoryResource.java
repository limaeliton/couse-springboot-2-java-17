package com.educandowebcouse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandowebcouse.entities.Category;
import com.educandowebcouse.entities.User;
import com.educandowebcouse.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
// Recursos da Aplicação Web
	
	@Autowired // injeção de dependência
	private CategoryService service;
	
// retorna respostas de requisição WEB
	@GetMapping 
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
