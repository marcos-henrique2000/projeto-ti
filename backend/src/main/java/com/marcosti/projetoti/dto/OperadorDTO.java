package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Operador;

public class OperadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String operador;
	private String cargo;
	
	public OperadorDTO() {}
	
	public OperadorDTO(Long id, String operador, String cargo) {
		this.id = id;
		this.operador = operador;
		this.cargo = cargo;
	}
	
	public OperadorDTO(Operador entity) {
		this.id = entity.getId();
		this.operador = entity.getOperador();
		this.cargo = entity.getCargo();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
