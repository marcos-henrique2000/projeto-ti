package com.marcosti.projetoti.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_chamado")
public class Chamado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String titulo;
	public String descricao;
	public LocalDate dataChamado;
	
	@ManyToOne
	@JoinColumn(name = "id_profissional")
	private Ti profissional;
	
	@ManyToOne
	@JoinColumn(name = "id_operador")
	private Operador operador;
	
	@ManyToOne
	@JoinColumn(name = "id_nivel")
	private Nivel nivel;
	
	public Chamado() {}

	public Chamado(Long id, String titulo, String descricao, Ti profissional, Operador operador, LocalDate dataChamado,
			Nivel nivel) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.profissional = profissional;
		this.operador = operador;
		this.dataChamado = dataChamado;
		this.nivel = nivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ti getProfissional() {
		return profissional;
	}

	public void setProfissional(Ti profissional) {
		this.profissional = profissional;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public LocalDate getDataChamado() {
		return dataChamado;
	}

	public void setDataChamado(LocalDate dataChamado) {
		this.dataChamado = dataChamado;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
