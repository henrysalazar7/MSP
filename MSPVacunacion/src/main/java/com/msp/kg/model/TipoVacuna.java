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
@Table(name = TipoVacuna.TABLE_NAME, schema = TipoVacuna.SCHEMA)
public class TipoVacuna {

	public static final String TABLE_NAME = "vc_tipo_vacuna";
	public static final String SCHEMA = "public";

	@Id
	@Column(name = "tv_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "tv_nombre", length = 64, nullable = false, unique = true)
	private String nombre;

	@Column(name = "tv_descripcion", length = 100)
	private String descripcion;

	@Column(name = "tv_laboratorio", length = 64)
	private String laboratorio;

	@Column(name = "tv_temperatura_min", nullable = false)
	private Double temperaturaMin;

	@Column(name = "tv_temperatura_max", nullable = false)
	private Double temperaturaMax;

	@Column(name = "tv_numero_dosis", nullable = false)
	private int numeroDosis;

	@Column(name = "tv_tiempo_entre_dosis", nullable = false)
	private int tiempoEntreDosis;

	@CreationTimestamp
	@Column(name = "tv_fecha_registro", nullable = false)
	private Date fechaRegistro;

	@Column(name = "tv_fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "tv_estado", length = 2, nullable = false)
	private String estado;

	@Column(name = "tv_observacion", length = 100)
	private String observacion;

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

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Double getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(Double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public Double getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getTiempoEntreDosis() {
		return tiempoEntreDosis;
	}

	public void setTiempoEntreDosis(int tiempoEntreDosis) {
		this.tiempoEntreDosis = tiempoEntreDosis;
	}
}
