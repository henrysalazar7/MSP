package com.msp.kg.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msp.kg.dto.LoteResponse;
import com.msp.kg.dto.ResponseBase;
import com.msp.kg.enums.ErrorEnum;
import com.msp.kg.exception.VacunacionException;
import com.msp.kg.model.Lote;
import com.msp.kg.model.TipoVacuna;
import com.msp.kg.repository.ILoteRepo;
import com.msp.kg.repository.ITipoVacunaRepo;
import com.msp.kg.service.ILoteService;
import com.msp.kg.service.IStockVacuna;
import com.msp.kg.utils.Constants;

@Service
public class LoteServiceImpl implements ILoteService {

	private static Logger LOG = LoggerFactory.getLogger(LoteServiceImpl.class);

	@Autowired
	private ILoteRepo repo;

	@Autowired
	private ITipoVacunaRepo tipoVacunaRepo;

	@Override
	public List<Lote> listarTodo() {
		return repo.findAll();
	}

	@Override
	public List<IStockVacuna> listarInventario() {
		return repo.listarInventario();
	}

	@Override
	public LoteResponse registrar(Lote lote) {
		LoteResponse response = new LoteResponse();

		try {
			LOG.debug("Inicia metodo registar");
			// VALIDAR SI EXISTE TIPO DE VACUNA
			Optional<TipoVacuna> tipoVacuna = tipoVacunaRepo.findById(lote.getTipoVacunaId().getId());
			if (tipoVacuna.isPresent()) {
				LOG.info(tipoVacuna.get().getNombre());
				Lote loteResponse = repo.save(lote);
				if (loteResponse != null) {
					response.setSuccess(true);
					response.setLote(loteResponse);
				}

			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1000);
			}
			return response;

		} catch (Exception ex) {
			VacunacionException.manageException(ex, response);
		} finally {
			LOG.debug("Finaliza metodo registar");
		}
		return response;
	}

	@Override
	public LoteResponse modificar(Lote lote) {
		LoteResponse response = new LoteResponse();

		try {
			LOG.debug("Inicia metodo modificar");
			// VALIDAR SI EXISTE LOTE
			Optional<Lote> loteResponseOptional = repo.findById(lote.getId());
			if (loteResponseOptional.isPresent()) {
				Lote loteToUpdate = loteResponseOptional.get();
				LOG.info("LOTE A MODIFICAR --> " + loteToUpdate.getId());

				if (lote.getCantidad() > 0) {
					loteToUpdate.setCantidad(lote.getCantidad());
				}
				if (lote.getFechaIngresoPais() != null) {
					loteToUpdate.setFechaIngresoPais(lote.getFechaIngresoPais());
				}
				if (lote.getEstado() != null) {
					loteToUpdate.setEstado(lote.getEstado());
				}
				if (lote.getObservacion() != null) {
					loteToUpdate.setObservacion(lote.getObservacion());
				}
				loteToUpdate.setFechaModificacion(new Date());

				// MODIFICAR LOTE EN BASE
				Lote loteModificado = repo.save(loteToUpdate);

				if (loteModificado != null) {
					response.setSuccess(true);
					response.setLote(loteModificado);
				}

			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1001);
			}
		} catch (Exception ex) {
			VacunacionException.manageException(ex, response);
		} finally {
			LOG.debug("Finaliza metodo modificar");
		}
		return response;
	}

	@Override
	public ResponseBase eliminarTodo(int id) {
		LOG.debug("Inicia metodo eliminar");
		ResponseBase response = new ResponseBase();
		try {
			Optional<Lote> loteResponseOptional = repo.findById(id);
			if (loteResponseOptional.isPresent()) {
				//repo.deleteById(id);				
				response.setSuccess(true);
			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1001);
			}
		} catch (Exception ex) {
			VacunacionException.manageException(ex, response);
		} finally {
			LOG.debug("Finaliza metodo eliminar");
		}
		return response;
	}

	@Override
	public ResponseBase eliminar(Lote lote) {
		ResponseBase response = new ResponseBase();

		try {
			LOG.debug("Inicia metodo eliminar");
			// VALIDAR SI EXISTE LOTE
			Optional<Lote> loteResponseOptional = repo.findById(lote.getId());
			if (loteResponseOptional.isPresent()) {
				Lote loteToUpdate = loteResponseOptional.get();
				LOG.info("LOTE A ELIMINAR --> " + loteToUpdate.getId());

				loteToUpdate.setEstado(Constants.DELETED_STATUS);
				loteToUpdate.setFechaModificacion(new Date());

				// MODIFICAR LOTE EN BASE
				Lote loteModificado = repo.save(loteToUpdate);

				if (loteModificado != null) {
					response.setSuccess(true);
				}

			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1001);
			}
		} catch (Exception ex) {
			VacunacionException.manageException(ex, response);
		} finally {
			LOG.debug("Finaliza metodo eliminar");
		}
		return response;
	}
}
