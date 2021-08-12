package com.msp.kg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.msp.kg.model.Usuario;
import com.msp.kg.repository.IUsuarioRepo;

//@RunA(SpringRunner.class)
@SpringBootTest
class MspVacunacionApplicationTests {

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setNombre("admin");
		us.setClave(encoder.encode("admin"));
		us.setDescripcion("Usuario Administrador");
		us.setUsuarioRegistrador(0);
		us.setEstado("A");
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equals(us.getClave()));
	}
}
