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

import com.marcosti.projetoti.dto.OperadorDTO;
import com.marcosti.projetoti.dto.OperadorSumDTO;
import com.marcosti.projetoti.entities.Operador;
import com.marcosti.projetoti.services.OperadorService;

@RestController
@RequestMapping(value = "/operadores")
public class OperadorController {
	
	@Autowired
	private OperadorService service;
	
	@GetMapping
	public ResponseEntity<List<OperadorDTO>> findAll(){
		List<OperadorDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum-by-operadores")
	public ResponseEntity<List<OperadorSumDTO>> amountGroupByOperadores(){
		List<OperadorSumDTO> list = service.amountGroupByOperadores();
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody OperadorDTO obj){
		Operador op = service.fromDTO(obj);
		op = service.insert(op);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}/operador")
	public ResponseEntity<OperadorDTO> setOperador(@Validated @RequestBody OperadorDTO objDTO, @PathVariable Long id){
		Operador op = service.fromDTO(objDTO);
		op.setId(id);
		return ResponseEntity.ok().body(service.setOperador(op, id));
	}
	
}
