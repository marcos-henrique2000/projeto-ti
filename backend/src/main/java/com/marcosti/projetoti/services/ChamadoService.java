package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosti.projetoti.dto.ChamadoDTO;
import com.marcosti.projetoti.entities.Chamado;
import com.marcosti.projetoti.repositories.ChamadoRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	public List<ChamadoDTO> findAll(){
		List<Chamado> result = repository.findAll();
		return result.stream().map(x -> new ChamadoDTO(x)).collect(Collectors.toList());
	}	
}