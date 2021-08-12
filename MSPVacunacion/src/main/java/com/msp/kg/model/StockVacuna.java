package com.msp.kg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = StockVacuna.TABLE_NAME, schema = StockVacuna.SCHEMA)
public class StockVacuna {

	public static final String TABLE_NAME = "vc_stock_vacuna";
	public static final String SCHEMA = "public";

	@Id
	@Column(name = "sv_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TipoVacuna tipoVacunaId;

	@Column(name = "sv_cantidad_total", nullable = false)
	private long cantidadTotal;

	@Column(name = "sv_cantidad_disponible", nullable = false)
	private long cantidadDisponible;

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

	public long getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(long cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public long getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(long cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
}
