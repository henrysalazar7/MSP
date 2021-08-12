package com.msp.kg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msp.kg.dto.LoteResponse;
import com.msp.kg.model.Lote;
import com.msp.kg.repository.ILoteRepo;
import com.msp.kg.service.ILoteService;
import com.msp.kg.service.IStockVacuna;

@RestController
@RequestMapping("/lote")
public class RestLoteController {

	@Autowired
	ILoteRepo repo;

	@Autowired
	ILoteService service;

	@GetMapping("/listarTodo")
	public List<Lote> listarTodo() {
		return service.listarTodo();
	}

	@GetMapping("/listarInventario")
	public List<IStockVacuna> listarInventario() {
		return service.listarInventario();
	}

	@PostMapping("/registrar")
	public LoteResponse registrar(@RequestBody Lote lote) {
		return service.registrar(lote);
	}

	@PutMapping("/modificar")
	public LoteResponse modificar(@RequestBody Lote lote) {
		return service.modificar(lote);
	}

	@DeleteMapping(name = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
