package com.msp.kg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msp.kg.model.Lote;
import com.msp.kg.service.IStockVacuna;

public interface ILoteRepo extends JpaRepository<Lote, Integer> {

	@Query(value = "select tv.tv_id as id, tv.tv_nombre as nombre, sum(lo.lo_cantidad) as cantidadTotal, sum(lo.lo_cantidad) as cantidadDisponible "
			+ "from public.vc_lote lo\r\n"
			+ "inner join public.vc_tipo_vacuna tv on tv.tv_id = lo.tipo_vacuna_id_tv_id\r\n"
			+ "where lo.lo_estado = 'A' and tv.tv_estado = 'A'\r\n"
			+ "group by tv.tv_id", nativeQuery = true)
	List<IStockVacuna> listarInventario();
	
	Lote findByNumero(String numero);
}
