package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Ti;

public class TiSumDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String profissional;
	private Long chamados;
	
	public TiSumDTO() {}
											//Long nivel1, long nivel2
	public TiSumDTO(Ti ti, Long chamados) {
		this.profissional = ti.getProfissional();
		this.chamados = chamados;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public Long getSum() {
		return chamados;
	}

	public void setSum(Long chamados) {
		this.chamados = chamados;
	}
}
