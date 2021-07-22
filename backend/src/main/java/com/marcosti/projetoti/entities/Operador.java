package com.marcosti.projetoti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.marcosti.projetoti.dto.OperadorDTO;

@Entity
@Table(name = "tb_operador")
public class Operador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String operador;
	private String cargo;
	
	@OneToMany(mappedBy = "operador")
	private List<Chamado> chamados = new ArrayList<>();
	
	public Operador() {}

	public Operador(Long id, String operador, String cargo) {
		this.id = id;
		this.operador = operador;
		this.cargo = cargo;
	}
	
	public Operador(Operador obj) {
		id = obj.getId();
		operador = obj.getOperador();
		cargo = obj.getCargo();
	}
	
	public Operador(OperadorDTO obj) {
		id = obj.getId();
		operador = obj.getOperador();
		cargo = obj.getCargo();
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

	public List<Chamado> getChamados() {
		return chamados;
	}
}
