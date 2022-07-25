package com.msp.kg.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msp.kg.dto.CiudadanoResponse;
import com.msp.kg.enums.ErrorEnum;
import com.msp.kg.enums.UsuarioEnum;
import com.msp.kg.exception.VacunacionException;
import com.msp.kg.model.Ciudadano;
import com.msp.kg.model.Usuario;
import com.msp.kg.repository.ICiudadanoRepo;
import com.msp.kg.repository.IUsuarioRepo;
import com.msp.kg.security.SecurityConfig;
import com.msp.kg.service.ICiudadanoService;
import com.msp.kg.utils.Constants;
import com.msp.kg.utils.Utils;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	private static Logger LOG = LoggerFactory.getLogger(CiudadanoServiceImpl.class);

	@Autowired
	private ICiudadanoRepo repo;

	@Autowired
	private IUsuarioRepo usuarioRepo;

	@Autowired
	private SecurityConfig secConfig;

	@Override
	public List<Ciudadano> listarTodo() {
		return repo.findAll();
	}

	@Override
	public CiudadanoResponse registrar(Ciudadano ciudadano) {
		CiudadanoResponse response = new CiudadanoResponse();

		try {
			LOG.info("Inicia metodo registar");

			// VALIDACIONES DE DATOS
			if (!this.validaCiudadano(ciudadano, response)) {
				return response;
			}

			// VALIDAR SI CEDULA NO EXISTE
			Ciudadano ciudadanoCedula = repo.findByCedula(ciudadano.getCedula());

			if (ciudadanoCedula == null) {
				// BUSCAR USUARIO CIUDADANO
				Usuario usuCiudadano = usuarioRepo.findByNombre(UsuarioEnum.ciudadano.toString());
				if (usuCiudadano != null) {
					// GUARDAR USUARIO
					Usuario us = new Usuario();
					us.setDescripcion("Usuario " + ciudadano.getCedula());
					us.setEstado(Constants.ACTIVED_STATUS);
					us.setNombre(ciudadano.getCedula());
					us.setClave(secConfig.passwordEncoder().encode(ciudadano.getCedula()));
					us.setUsuarioRegistrador(usuCiudadano.getId());
					Usuario usuNuevo = usuarioRepo.save(us);

					if (usuNuevo != null) {
						// GUARDAR CIUDADANO
						ciudadano.setUsuario(usuNuevo);
						Ciudadano ciudadanoResponse = repo.save(ciudadano);
						if (ciudadanoResponse != null) {
							response.setSuccess(true);
							response.setCiudadano(ciudadanoResponse);
						} else {
							VacunacionException.manageError(response, ErrorEnum.ERROR_1003);
						}
					} else {
						VacunacionException.manageError(response, ErrorEnum.ERROR_1003);
					}
				} else {
					VacunacionException.manageError(response, ErrorEnum.ERROR_1003);
				}
			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1002);
			}
			return response;

		} catch (Exception ex) {
			VacunacionException.manageException(ex, response);
		} finally {
			LOG.info("Finaliza metodo registar");
		}
		return response;
	}

	private boolean validaCiudadano(Ciudadano ciudadano, CiudadanoResponse response) {
		boolean isValid = false;
		isValid = Utils.validaCedula(ciudadano.getCedula());
		if (isValid) {
			isValid = Utils.validaCorreo(ciudadano.getCorreo());
			if (isValid) {
				isValid = Utils.validaLetras(ciudadano.getNombres());
				if (isValid) {
					isValid = Utils.validaLetras(ciudadano.getPrimerApellido());
					if (isValid) {
						isValid = Utils.validaLetras(ciudadano.getSegundoApellido());
						if (!isValid) {
							VacunacionException.manageError(response, ErrorEnum.ERROR_1006);
						}
					} else {
						VacunacionException.manageError(response, ErrorEnum.ERROR_1006);
					}
				} else {
					VacunacionException.manageError(response, ErrorEnum.ERROR_1006);
				}
			} else {
				VacunacionException.manageError(response, ErrorEnum.ERROR_1005);
			}
		} else {
			VacunacionException.manageError(response, ErrorEnum.ERROR_1004);
		}
		return isValid;
	}
}
