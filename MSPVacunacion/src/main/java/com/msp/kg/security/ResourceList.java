package com.msp.kg.security;

public class ResourceList {
	public static final String[] RES_PUBLIC = { "/", "/login", "/css/**", "/js/**", "images/**" };

	public static final String[] RES_ADMIN = { "/lote/listarTodo", "/lote/listarInventario", "/lote/registrar",
			"/lote/modificar", "/lote/eliminar" };

	public static final String[] RES_CIUDADANO = { "/vacunacion/listar" };

}
