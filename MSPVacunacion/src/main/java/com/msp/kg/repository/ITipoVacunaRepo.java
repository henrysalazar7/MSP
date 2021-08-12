package com.msp.kg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.kg.model.TipoVacuna;

public interface ITipoVacunaRepo extends JpaRepository<TipoVacuna, Integer> {
	
}
