package com.marcosti.projetoti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosti.projetoti.dto.NivelDTO;
import com.marcosti.projetoti.dto.NivelSumDTO;
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
}
