package com.msp.kg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.kg.model.Ciudadano;

public interface ICiudadanoRepo extends JpaRepository<Ciudadano, Integer> {

	Ciudadano findByCedula(String cedula);

	Ciudadano findByCorreo(String correo);
}
