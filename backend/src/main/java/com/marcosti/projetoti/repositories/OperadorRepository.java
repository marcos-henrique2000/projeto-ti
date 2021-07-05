package com.marcosti.projetoti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcosti.projetoti.dto.OperadorSumDTO;
import com.marcosti.projetoti.entities.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long>{
	
	@Query("SELECT NEW com.marcosti.projetoti.dto.OperadorSumDTO("
			+ "o, COUNT(o.operador)) FROM Operador AS o "
			+ "JOIN o.chamados d GROUP BY o.operador")
	List<OperadorSumDTO> amountGroupByOperadores();
}
