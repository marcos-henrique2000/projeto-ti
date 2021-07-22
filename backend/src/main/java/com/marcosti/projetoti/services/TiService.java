package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcosti.projetoti.dto.TiSumDTO;
import com.marcosti.projetoti.dto.TiDTO;
import com.marcosti.projetoti.entities.Ti;
import com.marcosti.projetoti.repositories.TiRepository;

@Service
public class TiService {
	
	@Autowired
	private TiRepository repository;
	
	public List<TiDTO> findAll(){
		List<Ti> result = repository.findAll();
		return result.stream().map(x -> new TiDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<TiSumDTO> amountGroupByChamados(){
		return repository.amountGroupByChamados();
	}
	
	public Ti insert(Ti obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Ti fromDTO(TiDTO objDTO) {
		return new Ti(objDTO.getId(), objDTO.getProfissional(), objDTO.getCargo());
	}
}