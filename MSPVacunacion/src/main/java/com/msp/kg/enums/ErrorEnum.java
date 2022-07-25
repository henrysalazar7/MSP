package com.msp.kg.enums;

public enum ErrorEnum {

	ERROR_5000("5000", "ERROR DURANTE LA EJECUCION DEL PROGRAMA"),
	ERROR_1000("1000", "NO EXISTE TIPO DE VACUNA"), 
	ERROR_1001("1001", "NO EXISTE LOTE"),
	ERROR_1002("1002", "USUARIO YA SE ENCUENTRA REGISTRAADO"),
	ERROR_1003("1003", "ERROR AL GUARDAR USUARIO"),
	ERROR_1004("1004", "CEDULA  NO ES VALIDA"),
	ERROR_1005("1005", "CORREO NO ES VALIDO"),
	ERROR_1006("1006", "NOMBRES Y APELLIDOS SOLO SE ACEPTAN LETRAS"),
	ERROR_1007("1007", "YA EXISTE NUMERO DE LOTE");

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
