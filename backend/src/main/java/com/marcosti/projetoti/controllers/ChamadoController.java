package com.marcosti.projetoti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosti.projetoti.dto.ChamadoDTO;
import com.marcosti.projetoti.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
	@GetMapping
	public ResponseEntity<Page<ChamadoDTO>> findAll(Pageable pageable){
		Page<ChamadoDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
}
