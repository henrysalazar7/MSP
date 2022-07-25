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

@Entity
@Table(name = Ciudadano.TABLE_NAME, schema = Ciudadano.SCHEMA)
public class Ciudadano {

	public static final String TABLE_NAME = "vc_ciudadano";
	public static final String SCHEMA = "public";

	@Id
	@Column(name = "ci_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ci_cedula", length = 10, nullable = false, unique = true)
	private String cedula;

	@Column(name = "ci_nombres", length = 64, nullable = false)
	private String nombres;

	@Column(name = "ci_primer_apellido", length = 64, nullable = false)
	private String primerApellido;

	@Column(name = "ci_segundo_apellido", length = 64, nullable = false)
	private String segundoApellido;

	@Column(name = "ci_fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;

	@Column(name = "ci_correo", length = 64, nullable = false)
	private String correo;

	@Column(name = "ci_enfermedad", length = 2, nullable = false)
	private String enfermedad;

	@Column(name = "ci_telefono_fijo", length = 32)
	private String telefonoFijo;

	@Column(name = "ci_telefono_movil", length = 16, nullable = false)
	private String telefonoMovil;

	@Column(name = "ci_estado", length = 2, nullable = false)
	private String estado;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
