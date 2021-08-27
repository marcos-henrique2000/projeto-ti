package com.marcosti.projetoti.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcosti.projetoti.dto.OperadorDTO;
import com.marcosti.projetoti.dto.OperadorSumDTO;
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
	 
	@Transactional(readOnly = true)
	public List<OperadorSumDTO> amountGroupByOperadores(){
		return repository.amountGroupByOperadores();
	}
	
	@Transactional
	public OperadorDTO setOperador(Operador obj, Long id) {
		Operador op = repository.getById(id);
		updateData(op, obj);
		repository.save(op);
		return new OperadorDTO(op);
	}
	
	public void updateData(Operador newObj, Operador obj) {
		newObj.setCargo(obj.getCargo());
		newObj.setOperador(obj.getOperador());
	}
	
	public Operador insert(Operador obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Operador fromDTO(OperadorDTO obj) {
		return new Operador(obj.getId(), obj.getOperador(), obj.getCargo());
	}
}