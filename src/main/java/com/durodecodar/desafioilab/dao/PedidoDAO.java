package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.durodecodar.desafioilab.model.Pedido;

public interface PedidoDAO  extends CrudRepository<Pedido, Integer>{
	
//	@Query("SELECT new ")
//	public List<Pedido> listarTodosProdutos();
}
