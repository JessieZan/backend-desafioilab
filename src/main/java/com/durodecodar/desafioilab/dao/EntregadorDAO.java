package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.dto.EntregadorDTO;
import com.durodecodar.desafioilab.model.Entregador;

public interface EntregadorDAO extends CrudRepository<Entregador, Integer>{
	@Query("    SELECT "
			+ "new com.durodecodar.desafioilab.dto.EntregadorDTO("
			+ "  entregador.id,"
			+ "  entregador.nome,"
			+ "  entregador.email,"
			+ "  entregador.telefone) "
			+ "FROM Entregador as entregador")
	public List<EntregadorDTO> recuperarTodos();
	
	@Query(" SELECT "
			+ " new com.durodecodar.desafioilab.dto.EntregadorDTO("
			+ "  entregador.id,"
			+ "  entregador.nome,"
			+ "  entregador.email,"
			+ "  entregador.telefone)"
			+ "FROM Entregador as entregador WHERE entregador.id = :id")
	public EntregadorDTO recuperarPeloId(@Param("id") Integer numero);
}
