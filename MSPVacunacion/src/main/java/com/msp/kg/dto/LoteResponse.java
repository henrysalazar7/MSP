package com.msp.kg.dto;

import com.msp.kg.model.Lote;

public class LoteResponse extends ResponseBase {
	private Lote lote;

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}
}
