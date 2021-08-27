package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcosti.projetoti.dto.TiDTO;
import com.marcosti.projetoti.dto.TiSumDTO;
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
	
	@Transactional
	public TiDTO putTi(Ti obj, Long id) {
		Ti ti = repository.getById(id);
		updateData(ti, obj);
		repository.save(ti);
		return new TiDTO(ti);
	}
	
	public Ti insert(Ti obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Ti fromDTO(TiDTO objDTO) {
		return new Ti(objDTO.getId(), objDTO.getProfissional(), objDTO.getCargo());
	}
	
	/*
	public Ti update(Ti obj) {
		Ti newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public Ti find(Long id) {
		Optional<Ti> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Ti.class.getName()));
	}*/
	
	private void updateData(Ti newObj, Ti obj) {
		newObj.setCargo(obj.getCargo());
		newObj.setProfissional(obj.getProfissional());
	}
}