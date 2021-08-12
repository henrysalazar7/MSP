package com.msp.kg;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msp.kg.model.Rol;
import com.msp.kg.repository.IRolRepo;

@SpringBootTest
class UsuarioRolTest2 {

	private static Logger LOG = LoggerFactory.getLogger(UsuarioRolTest2.class);

	private final String USUARIO_ADMIN = "admin";

	@Autowired
	private IRolRepo repoRol;

	@Test
	public void crearTest() {
		List<Rol> roles = repoRol.findAllRolesByUsername(USUARIO_ADMIN);
		for (Rol rol : roles) {
			LOG.info(rol.getNombre());
		}
	}
}
