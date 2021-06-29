package com.marcosti.projetoti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<ChamadoDTO>> findAll(){
		List<ChamadoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
}
