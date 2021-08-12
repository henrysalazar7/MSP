package com.msp.kg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = Rol.TABLE_NAME, schema = Rol.SCHEMA)
public class Rol {

	public static final String TABLE_NAME = "vc_rol";
	public static final String SCHEMA = "security";

	@Id
	@Column(name = "ro_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ro_nombre", length = 64, nullable = false, unique = true)
	private String nombre;

	@Column(name = "ro_descripcion", length = 64)
	private String descripcion;

	@CreationTimestamp
	@Column(name = "ro_fecha_registro", nullable = false)
	private Date fechaRegistro;

	@Column(name = "ro_fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "ro_usuario_registrador", nullable = false)
	private int usuarioRegistrador;

	@Column(name = "ro_usuario_modificador")
	private int usuarioModificador;

	@Column(name = "ro_estado", length = 2, nullable = false)
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getUsuarioRegistrador() {
		return usuarioRegistrador;
	}

	public void setUsuarioRegistrador(int usuarioRegistrador) {
		this.usuarioRegistrador = usuarioRegistrador;
	}

	public int getUsuarioModificador() {
		return usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
