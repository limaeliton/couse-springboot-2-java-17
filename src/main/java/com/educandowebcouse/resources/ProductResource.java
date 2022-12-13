package com.educandowebcouse.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandowebcouse.entities.Product;
import com.educandowebcouse.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
// Recursos da Aplicação Web
	
	@Autowired // injeção de dependência
	private ProductService service;
	
// retorna respostas de requisição WEB
	@GetMapping 
	public ResponseEntity<List <Product>> findAll(){
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product>findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
