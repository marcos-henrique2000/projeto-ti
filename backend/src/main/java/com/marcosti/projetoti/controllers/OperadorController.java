package com.marcosti.projetoti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosti.projetoti.dto.OperadorDTO;
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
}
