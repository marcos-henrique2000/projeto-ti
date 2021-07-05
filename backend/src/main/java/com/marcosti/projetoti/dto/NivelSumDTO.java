package com.marcosti.projetoti.dto;

import java.io.Serializable;

import com.marcosti.projetoti.entities.Nivel;

public class NivelSumDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer nivel;
	private String descricao;
	private Long chamados;
	
	public NivelSumDTO() {}

	public NivelSumDTO(Nivel entity, Long chamados) {
		this.nivel = entity.getNivel();
		this.descricao = entity.getDescricao();
		this.chamados = chamados;
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

	public Long getChamados() {
		return chamados;
	}

	public void setChamados(Long chamados) {
		this.chamados = chamados;
	}
}
