package com.marcosti.projetoti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcosti.projetoti.dto.ChamadoDTO;
import com.marcosti.projetoti.entities.Chamado;
import com.marcosti.projetoti.repositories.ChamadoRepository;
import com.marcosti.projetoti.repositories.NivelRepository;
import com.marcosti.projetoti.repositories.OperadorRepository;
import com.marcosti.projetoti.repositories.TiRepository;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TiRepository tiRepository;
	
	@Autowired
	private NivelRepository nivelRepository;
	
	@Autowired
	private OperadorRepository operadorRepository;
	
	@Transactional(readOnly = true)
	public Page<ChamadoDTO> findAll(Pageable pageable){
		
		tiRepository.findAll();
		nivelRepository.findAll();
		operadorRepository.findAll();
		
		Page<Chamado> result = repository.findAll(pageable);
		return result.map(x -> new ChamadoDTO(x));
	}	
}