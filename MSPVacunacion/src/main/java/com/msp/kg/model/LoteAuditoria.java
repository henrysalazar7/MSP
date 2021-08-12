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
@Table(name = LoteAuditoria.TABLE_NAME, schema = LoteAuditoria.SCHEMA)
public class LoteAuditoria {

	public static final String TABLE_NAME = "vc_lote_auditoria";
	public static final String SCHEMA = "public";

	@Id
	@Column(name = "la_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Lote loteId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Usuario usuarioId;

	@Column(name = "la_numero", length = 64, nullable = false, unique = true)
	private String numero;

	@Column(name = "la_fecha_fabricacion", nullable = false)
	private Date fechaFabricacion;

	@Column(name = "la_fecha_expiracion", nullable = false)
	private Date fechaExpiracion;

	@Column(name = "la_cantidad", nullable = false)
	private int cantidad;

	@Column(name = "la_fecha_ingreso")
	private Date fechaIngreso;

	@CreationTimestamp
	@Column(name = "la_fecha_registro", nullable = false)
	private Date fechaRegistro;

	@Column(name = "la_fecha_modificacion")
	private Date fechaModificacion;

	@Column(name = "la_estado", length = 2, nullable = false)
	private String estado;

	@Column(name = "la_observacion", length = 100)
	private String observacion;

	@Column(name = "la_operacion", length = 2) // I-Insert, U-Update, D-Delete
	private String operacion;

	@Column(name = "la_terminal", length = 20)
	private String terminal;
}
