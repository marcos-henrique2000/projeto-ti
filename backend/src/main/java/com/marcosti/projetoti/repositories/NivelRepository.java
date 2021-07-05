package com.marcosti.projetoti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcosti.projetoti.dto.NivelSumDTO;
import com.marcosti.projetoti.entities.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, Long>{
	
	@Query("SELECT NEW com.marcosti.projetoti.dto.NivelSumDTO("
			+ "n, COUNT(n.nivel)) FROM Nivel AS n "
			+ "JOIN n.chamados d GROUP BY n.nivel")
	List<NivelSumDTO> amountGroupByNivel();
	
}
