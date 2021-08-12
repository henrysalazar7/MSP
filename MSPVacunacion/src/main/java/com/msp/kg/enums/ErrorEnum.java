package com.msp.kg.enums;

public enum ErrorEnum {

	ERROR_5000("5000", "ERROR DURANTE LA EJECUCION DEL PROGRAMA"),
	ERROR_1000("1000", "NO EXISTE TIPO DE VACUNA"), 
	ERROR_1001("1001", "NO EXISTE LOTE");

	private String code;
	private String description;

	private ErrorEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
