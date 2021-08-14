package com.msp.kg.service;

import java.util.List;

import com.msp.kg.dto.LoteResponse;
import com.msp.kg.dto.ResponseBase;
import com.msp.kg.model.Lote;

public interface ILoteService {
	List<Lote> listarTodo();

	List<IStockVacuna> listarInventario();

	LoteResponse registrar(Lote lote);

	LoteResponse modificar(Lote lote);

	ResponseBase eliminarTodo(int id);

	ResponseBase eliminar(Lote lote);
}
