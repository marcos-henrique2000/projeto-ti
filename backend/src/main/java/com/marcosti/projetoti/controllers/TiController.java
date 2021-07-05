package com.marcosti.projetoti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosti.projetoti.dto.TiSumDTO;
import com.marcosti.projetoti.dto.TiDTO;
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
	
}
