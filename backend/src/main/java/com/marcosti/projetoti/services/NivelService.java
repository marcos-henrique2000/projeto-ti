package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosti.projetoti.dto.NivelDTO;
import com.marcosti.projetoti.entities.Nivel;
import com.marcosti.projetoti.repositories.NivelRepository;

@Service
public class NivelService {
	
	@Autowired
	private NivelRepository repository;
	
	public List<NivelDTO> findAll(){
		List<Nivel> result = repository.findAll();
		return result.stream().map(x -> new NivelDTO(x)).collect(Collectors.toList());
	}	
}