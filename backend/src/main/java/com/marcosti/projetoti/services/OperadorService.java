package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosti.projetoti.dto.OperadorDTO;
import com.marcosti.projetoti.entities.Operador;
import com.marcosti.projetoti.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository repository;
	
	public List<OperadorDTO> findAll(){
		List<Operador> result = repository.findAll();
		return result.stream().map(x -> new OperadorDTO(x)).collect(Collectors.toList());
	}	
}