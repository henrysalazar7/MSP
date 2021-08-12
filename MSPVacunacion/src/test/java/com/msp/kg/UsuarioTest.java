package com.msp.kg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.msp.kg.model.Usuario;
import com.msp.kg.repository.IUsuarioRepo;

@SpringBootTest
class UsuarioTest {


	private final String USUARIO_ADMIN = "admin";
	
	@Autowired
	private IUsuarioRepo repoUsuario;
	
	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearTest() {
		/*Usuario us = new Usuario();
		us.setNombre("admin");
		us.setClave(encoder.encode("admin"));
		us.setDescripcion("Usuario Administrador");
		us.setUsuarioRegistrador(0);
		us.setEstado("A");		
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equals(us.getClave()));
		
		// ENCONTRAR USUARIO ADMINISTRADOR
		Usuario usAdmin = repoUsuario.findByNombre(USUARIO_ADMIN);
				
		Usuario us = new Usuario();
		us.setNombre("ciudadano");
		us.setClave(encoder.encode("ciudadano"));
		us.setDescripcion("Usuario Ciudadano Test");
		us.setUsuarioRegistrador(usAdmin.getId());
		us.setEstado("A");		
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equals(us.getClave()));*/	
	}
}
