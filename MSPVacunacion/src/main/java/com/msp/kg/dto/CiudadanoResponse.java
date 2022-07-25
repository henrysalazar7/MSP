package com.msp.kg.dto;

import com.msp.kg.model.Ciudadano;

public class CiudadanoResponse extends ResponseBase {
	private Ciudadano ciudadano;

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
}
