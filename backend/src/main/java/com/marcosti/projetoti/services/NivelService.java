package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcosti.projetoti.dto.NivelDTO;
import com.marcosti.projetoti.dto.NivelSumDTO;
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
	
	@Transactional(readOnly = true)
	public List<NivelSumDTO> amountGroupByNivel(){
		return repository.amountGroupByNivel();
	}
}