package com.msp.kg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msp.kg.model.Rol;

public interface IRolRepo extends JpaRepository<Rol, Integer> {

	Rol findByNombre(String nombre);
	
	@Query(value = "select rol.* from security.vc_rol rol\r\n"
			+ "inner join security.vc_usuario_rol ur on rol.ro_id = ur.rol_id_ro_id\r\n"
			+ "inner join security.vc_usuario usu on ur.usuario_id_us_id = usu.us_id\r\n"
			+ "where us_nombre = :username ", nativeQuery = true)
	List<Rol> findAllRolesByUsername(@Param("username") String username);
}
