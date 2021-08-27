package com.marcosti.projetoti.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcosti.projetoti.dto.ChamadoDTO;
import com.marcosti.projetoti.entities.Chamado;
import com.marcosti.projetoti.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ChamadoDTO>> findAll(Pageable pageable){
		Page<ChamadoDTO> list = service.findAll(pageable);
		
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ChamadoDTO obj){
		Chamado ch = service.fromDTO(obj);
		ch = service.insert(ch);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}/chamado")
	public ResponseEntity<ChamadoDTO> putChamado(@Validated @RequestBody ChamadoDTO objDTO, @PathVariable Long id){
		Chamado ch = service.fromDTO(objDTO);
		ch.setId(id);
		return ResponseEntity.ok().body(service.putChamado(ch, id));
	}
}
