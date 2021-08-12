package com.msp.kg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.kg.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);
}
