package com.marcosti.projetoti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nivel")
public class Nivel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer nivel;
	private String descricao;
	
	@OneToMany(mappedBy = "nivel")
	private List<Chamado> chamados = new ArrayList<>();
	
	public Nivel() {}

	public Nivel(Long id, int nivel, String descricao) {
		this.id = id;
		this.nivel = nivel;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Chamado> getChamados() {
		return chamados;
	}
}
