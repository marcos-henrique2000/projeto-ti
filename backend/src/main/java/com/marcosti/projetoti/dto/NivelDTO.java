package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Nivel;

public class NivelDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer nivel;
	private String descricao;
	
	public NivelDTO() {}

	public NivelDTO(Long id, Integer nivel, String descricao) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.descricao = descricao;
	}

	public NivelDTO(Nivel entity) {
		id = entity.getId();
		nivel = entity.getNivel();
		descricao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
