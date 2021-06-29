package com.marcosti.projetoti.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.marcosti.projetoti.entities.Chamado;

public class ChamadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDate datachamado;
	
	private TiDTO profissional; 
	private OperadorDTO operador;
	private NivelDTO nivel;
	
	public ChamadoDTO() {}

	public ChamadoDTO(Long id, String titulo, String descricao, LocalDate datachamado, TiDTO profissional,
			OperadorDTO operador, NivelDTO nivel) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.datachamado = datachamado;
		this.profissional = profissional;
		this.operador = operador;
		this.nivel = nivel;
	};
	
	public ChamadoDTO(Chamado entity) {
		id = entity.getId();
		titulo = entity.getTitulo();
		descricao = entity.getDescricao();
		datachamado = entity.getDataChamado();
		profissional = new TiDTO(entity.getProfissional());
		operador = new OperadorDTO(entity.getOperador());
		nivel = new NivelDTO(entity.getNivel());
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

	public LocalDate getDatachamado() {
		return datachamado;
	}

	public void setDatachamado(LocalDate datachamado) {
		this.datachamado = datachamado;
	}

	public TiDTO getProfissional() {
		return profissional;
	}

	public void setProfissional(TiDTO profissional) {
		this.profissional = profissional;
	}

	public OperadorDTO getOperador() {
		return operador;
	}

	public void setOperador(OperadorDTO operador) {
		this.operador = operador;
	}

	public NivelDTO getNivel() {
		return nivel;
	}

	public void setNivel(NivelDTO nivel) {
		this.nivel = nivel;
	};
}
