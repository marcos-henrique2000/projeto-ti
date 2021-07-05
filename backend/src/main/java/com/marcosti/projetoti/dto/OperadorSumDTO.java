package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Operador;

public class OperadorSumDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String operador;
	private String cargo;
	private Long chamados;
	
	public OperadorSumDTO() {}

	public OperadorSumDTO(Operador entity, Long chamados) {
		operador = entity.getOperador();
		cargo = entity.getCargo();
		this.chamados = chamados;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getChamados() {
		return chamados;
	}

	public void setChamados(Long chamados) {
		this.chamados = chamados;
	}
}
