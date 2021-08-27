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
	
	@Transactional
	public NivelDTO setNivel(Nivel obj, Long id) {
		Nivel nivel = repository.getById(id);
		updateData(nivel, obj);
		repository.save(nivel);
		return new NivelDTO(nivel);
	}
	
	public Nivel insert(Nivel obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Nivel fromDTO(NivelDTO objDTO) {
		return new Nivel(objDTO.getId(), objDTO.getNivel(), objDTO.getDescricao());
	}
	
	private void updateData(Nivel newObj, Nivel obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setId(obj.getId());
		newObj.setNivel(obj.getNivel());
	}
}