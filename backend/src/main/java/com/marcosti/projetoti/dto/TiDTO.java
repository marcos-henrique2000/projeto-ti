package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Ti;

public class TiDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String profissional;
	private String cargo;
	
	public TiDTO() {}

	public TiDTO(Long id, String profissional, String cargo) {
		this.id = id;
		this.profissional = profissional;
		this.cargo = cargo;
	}

	public TiDTO(Ti entity) {
		id = entity.getId();
		profissional = entity.getProfissional();
		cargo = entity.getCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
