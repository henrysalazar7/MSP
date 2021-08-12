package com.msp.kg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msp.kg.model.Rol;
import com.msp.kg.model.Usuario;
import com.msp.kg.model.UsuarioRol;
import com.msp.kg.repository.IRolRepo;
import com.msp.kg.repository.IUsuarioRepo;
import com.msp.kg.repository.IUsuarioRolRepo;

@SpringBootTest
class UsuarioRolTest {

	private final String USUARIO_ADMIN = "admin";
	private final String ROL_ADMIN = "ADMIN";
	
	private final String USUARIO_CIUDADANO = "ciudadano";
	private final String ROL_CIUDADANO = "CIUDADANO";

	@Autowired
	private IRolRepo repoRol;

	@Autowired
	private IUsuarioRepo repoUsuario;

	@Autowired
	private IUsuarioRolRepo repoUsuarioRol;

	/*
	@Test
	public void crearTest() {
		// ENCONTRAR USUARIO ADMINISTRADOR
		Usuario us = repoUsuario.findByNombre(USUARIO_ADMIN);

		// ENCONTRAR ROL ADMINISTRADOR
		Rol rol = repoRol.findByNombre(ROL_ADMIN);

		UsuarioRol usuRol = new UsuarioRol();
		usuRol.setUsuarioRegistrador(us.getId());
		usuRol.setUsuarioId(us);
		usuRol.setRolId(rol);

		UsuarioRol retorno = repoUsuarioRol.save(usuRol);
		assertTrue(retorno.getUsuarioId().equals(usuRol.getUsuarioId()));
	}
	
	*/
	
	@Test
	public void crearUsuarioRolCiu() {
		// ENCONTRAR USUARIO ADMINISTRADOR
		Usuario usAdmin = repoUsuario.findByNombre(USUARIO_ADMIN);
				
		// ENCONTRAR USUARIO CIUDADANO
		Usuario us = repoUsuario.findByNombre(USUARIO_CIUDADANO);

		// ENCONTRAR ROL CIUDADANO
		Rol rol = repoRol.findByNombre(ROL_CIUDADANO);

		UsuarioRol usuRol = new UsuarioRol();
		usuRol.setUsuarioRegistrador(usAdmin.getId());
		usuRol.setUsuarioId(us);
		usuRol.setRolId(rol);

		UsuarioRol retorno = repoUsuarioRol.save(usuRol);
		assertTrue(retorno.getUsuarioId().equals(usuRol.getUsuarioId()));
	}
}
