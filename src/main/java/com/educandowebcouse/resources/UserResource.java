package com.educandowebcouse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandowebcouse.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
// Recursos da Aplicação Web
	
// retorna respostas de requisição WEB
	@GetMapping 
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
