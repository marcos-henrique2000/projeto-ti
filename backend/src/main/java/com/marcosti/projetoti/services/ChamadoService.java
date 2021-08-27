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
	
	@Transactional
	public ChamadoDTO putChamado(Chamado obj, Long id) {
		Chamado ch = repository.getById(id);
		updateData(ch, obj);
		repository.save(ch);
		return new ChamadoDTO(ch);
	}
	
	public Chamado insert(Chamado obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Chamado fromDTO(ChamadoDTO obj) {
		return new Chamado(obj);
	}
	
	public void updateData(Chamado newObjt, Chamado obj) {
		newObjt.setTitulo(obj.getTitulo());
		newObjt.setDescricao(obj.getDescricao());
		newObjt.setDataChamado(obj.getDataChamado());
		newObjt.setId(obj.getId());
		newObjt.setNivel(obj.getNivel());
		newObjt.setOperador(obj.getOperador());
		newObjt.setProfissional(obj.getProfissional());
	}
	
}