package com.msp.kg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = UsuarioRol.TABLE_NAME, schema = UsuarioRol.SCHEMA)
public class UsuarioRol {

	public static final String TABLE_NAME = "vc_usuario_rol";
	public static final String SCHEMA = "security";

	@Id
	@Column(name = "ur_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Usuario usuarioId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Rol rolId;

	@CreationTimestamp
	@Column(name = "ur_fecha_registro", nullable = false)
	private Date fechaRegistro;

	@Column(name = "ur_fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "us_usuario_registrador", nullable = false)
	private int usuarioRegistrador;

	@Column(name = "us_usuario_modificador")
	private int usuarioModificador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
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
}
