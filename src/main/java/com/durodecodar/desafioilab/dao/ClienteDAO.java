package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.dto.ClienteDTO;
import com.durodecodar.desafioilab.model.Cliente;

public interface ClienteDAO  extends CrudRepository<Cliente, Integer>{
	
	@Query("    SELECT "
			+ "new com.durodecodar.desafioilab.dto.ClienteDTO("
			+ "  cliente.id,"
			+ "  cliente.nome)"
			+ "FROM Cliente as cliente")
	public List<ClienteDTO> recuperarTodos();
	
	@Query(" SELECT "
			+ " new com.durodecodar.desafioilab.dto.ClienteDTO("
			+ "  cliente.id,"
			+ "  cliente.nome)"
			+ "FROM Cliente as cliente WHERE cliente.id = :id")
	public ClienteDTO recuperarPeloId(@Param("id") Integer numero);
}
