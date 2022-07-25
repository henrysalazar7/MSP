package com.msp.kg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msp.kg.dto.CiudadanoResponse;
import com.msp.kg.model.Ciudadano;
import com.msp.kg.service.ICiudadanoService;

@RestController
@RequestMapping("/ciudadano")
public class RestCiudadanoController {

	@Autowired
	ICiudadanoService service;

	@GetMapping("/listar")
	public List<Ciudadano> listar() {
		return service.listarTodo();
	}

	@PostMapping("/registrar")
	public CiudadanoResponse registrar(@RequestBody Ciudadano ciudadano) {
		return service.registrar(ciudadano);
	}
}
