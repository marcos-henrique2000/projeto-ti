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

import com.marcosti.projetoti.dto.TiDTO;
import com.marcosti.projetoti.dto.TiSumDTO;
import com.marcosti.projetoti.entities.Ti;
import com.marcosti.projetoti.services.TiService;

@RestController
@RequestMapping(value = "/tis")
public class TiController {
	
	@Autowired
	private TiService service;
	
	@GetMapping
	public ResponseEntity<List<TiDTO>> findAll(){
		List<TiDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum-by-chamados")
	public ResponseEntity<List<TiSumDTO>> amountGroupByChamados(){
		List<TiSumDTO> list = service.amountGroupByChamados();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/{id}/ti")
	public ResponseEntity<TiDTO> putTi(@Validated @RequestBody TiDTO objDTO,@PathVariable Long id){
		Ti ti = service.fromDTO(objDTO);
		ti.setId(id);
		return ResponseEntity.ok().body(service.putTi(ti, id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody TiDTO objDTO){
		Ti ti = service.fromDTO(objDTO);
		ti = service.insert(ti);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(objDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}