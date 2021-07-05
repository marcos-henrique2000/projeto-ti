package com.marcosti.projetoti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcosti.projetoti.dto.TiSumDTO;
import com.marcosti.projetoti.entities.Ti;

public interface TiRepository extends JpaRepository<Ti, Long>{
																				//   COUNT(), COUNT()
	@Query("SELECT NEW com.marcosti.projetoti.dto.TiSumDTO( "
			+ "e, COUNT(e.profissional)) FROM Ti AS e "
			+ "JOIN e.chamados d GROUP BY e.profissional")
	List<TiSumDTO> amountGroupByChamados();
	
	/*
	@Query("SELECT com.marcosti.projetoti.dto.ChamadosSumDTO(obj.profissional, COUNT(obj.profissional)) "
			+ "FROM Ti AS obj JOIN Chamado AS obj2 WHERE obj2.id == obj.id")
	*/
}
