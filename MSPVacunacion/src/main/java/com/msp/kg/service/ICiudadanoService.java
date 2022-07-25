package com.msp.kg.service;

import java.util.List;

import com.msp.kg.dto.CiudadanoResponse;
import com.msp.kg.model.Ciudadano;

public interface ICiudadanoService {
	
	List<Ciudadano> listarTodo();

	CiudadanoResponse registrar(Ciudadano ciudadano);
}
