package com.msp.kg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.kg.model.Lote;

public interface ILoteAuditoriaRepo extends JpaRepository<Lote, Integer> {
	//void registrar(Lote lote);
}
