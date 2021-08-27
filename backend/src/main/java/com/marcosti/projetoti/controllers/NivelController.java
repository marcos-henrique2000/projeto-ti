package com.marcosti.projetoti.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcosti.projetoti.dto.NivelDTO;
import com.marcosti.projetoti.dto.NivelSumDTO;
import com.marcosti.projetoti.entities.Nivel;
import com.marcosti.projetoti.services.NivelService;

@RestController
@RequestMapping(value = "/niveis")
public class NivelController {
	
	@Autowired
	private NivelService service;
	
	@GetMapping
	public ResponseEntity<List<NivelDTO>> findAll(){
		List<NivelDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum-by-nivel")
	public ResponseEntity<List<NivelSumDTO>> amountGroupByNivel(){
		List<NivelSumDTO> list = service.amountGroupByNivel();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/{id}/nivel")
	public ResponseEntity<NivelDTO> setNivel(@Validated @RequestBody NivelDTO objDTO, @PathVariable Long id){
		Nivel nivel = service.fromDTO(objDTO);
		nivel.setId(id);
		return ResponseEntity.ok().body(service.setNivel(nivel, id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody NivelDTO obj){
		Nivel nivel = service.fromDTO(obj);
		nivel = service.insert(nivel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	/*
	@PutMapping("/{id}/nivel")
	public ResponseEntity<NivelDTO> setNivel(@PathVariable Long id){
		NivelDTO dto = service.setNivel(id);
		return ResponseEntity.ok().body(dto);
	}*/
}
