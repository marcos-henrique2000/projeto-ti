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
@Table(name = "tb_ti")
public class Ti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String profissional;
	private String cargo;
	
	@OneToMany(mappedBy = "profissional")
	private List<Chamado> chamados = new ArrayList<>();
	
	public Ti() {}

	public Ti(Long id, String profissional, String cargo) {
		this.id = id;
		this.profissional = profissional;
		this.cargo = cargo;
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

	public List<Chamado> getChamados() {
		return chamados;
	}
}
