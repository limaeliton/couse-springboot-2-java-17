package com.educandowebcouse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandowebcouse.entities.User;
import com.educandowebcouse.repositories.UserRepository;

@Configuration
@Profile("test") // configuração especifica para o perfil de teste, esta na
					// application.properties
public class TestConfig implements CommandLineRunner {
// CommandLineRunner executa quando o programa for iniciado
// serve para popular o banco de dados com alguns objetos, e fazer a injeção de depêndencias no UserRepository

	@Autowired // faz a injeção de dependências
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
// null pois o id vai ser gerado pelo banco de dados	
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
// salva uma lista de objetos no banco
		userRepository.saveAll(Arrays.asList(u1,u2));

	}

}
