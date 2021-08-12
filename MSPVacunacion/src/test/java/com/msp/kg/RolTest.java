package com.msp.kg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msp.kg.model.Rol;
import com.msp.kg.model.Usuario;
import com.msp.kg.repository.IRolRepo;
import com.msp.kg.repository.IUsuarioRepo;

@SpringBootTest
class RolTest {

	private final String USUARIO_ADMIN = "admin";

	@Autowired
	private IRolRepo repo;

	@Autowired
	private IUsuarioRepo repoUsuario;

	@Test
	public void crearTest() {
		// ENCONTRAR USUARIO ADMINISTRADOR
		Usuario us = repoUsuario.findByNombre(USUARIO_ADMIN);
		/*if (us == null || us.getId() <= 0) {
			UsuarioTest usuTest = new UsuarioTest();
			usuTest.crearTest();
			us = repoUsuario.findByNombre(USUARIO_ADMIN);
		}
		*/
		Rol rol = new Rol();
		rol.setNombre("ADMIN");
		rol.setDescripcion("Rol Administrador");
		rol.setEstado("A");
		rol.setUsuarioRegistrador(us.getId());
		Rol retorno = repo.save(rol);
		assertTrue(retorno.getNombre().equals(rol.getNombre()));

		Rol rolCiu = new Rol();
		rolCiu.setNombre("CIUDADANO");
		rolCiu.setDescripcion("Rol Ciudadano");
		rolCiu.setEstado("A");
		rolCiu.setUsuarioRegistrador(us.getId());
		Rol retornoCiu = repo.save(rolCiu);

		assertTrue(retornoCiu.getNombre().equals(rolCiu.getNombre()));
	}
}
