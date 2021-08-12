package com.msp.kg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msp.kg.model.TipoVacuna;
import com.msp.kg.repository.ITipoVacunaRepo;

@RestController
@RequestMapping("/vacunacion")
public class RestVacunacionController {

	@Autowired
	ITipoVacunaRepo repo;

	@GetMapping("/listar")
	public List<TipoVacuna> listar() {
		return repo.findAll();
	}
}
