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
@Table(name = Lote.TABLE_NAME, schema = Lote.SCHEMA)
public class Lote {

	public static final String TABLE_NAME = "vc_lote";
	public static final String SCHEMA = "public";

	@Id
	@Column(name = "lo_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TipoVacuna tipoVacunaId;

	@Column(name = "lo_numero", length = 64, nullable = false, unique = true)
	private String numero;

	@Column(name = "lo_fecha_fabricacion", nullable = false)
	private Date fechaFabricacion;

	@Column(name = "lo_fecha_expiracion", nullable = false)
	private Date fechaExpiracion;

	@Column(name = "lo_cantidad", nullable = false)
	private long cantidad;

	@Column(name = "lo_fecha_ingreso_pais")
	private Date fechaIngresoPais;

	@CreationTimestamp
	@Column(name = "lo_fecha_registro", nullable = false)
	private Date fechaRegistro;

	@Column(name = "lo_fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "lo_estado", length = 2, nullable = false)
	private String estado;

	@Column(name = "lo_observacion", length = 200)
	private String observacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoVacuna getTipoVacunaId() {
		return tipoVacunaId;
	}

	public void setTipoVacunaId(TipoVacuna tipoVacunaId) {
		this.tipoVacunaId = tipoVacunaId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIngresoPais() {
		return fechaIngresoPais;
	}

	public void setFechaIngresoPais(Date fechaIngresoPais) {
		this.fechaIngresoPais = fechaIngresoPais;
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
}
