package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.model.Pedido;

public interface PedidoDAO  extends CrudRepository<Pedido, Integer>{
	
	
	public List<Pedido> findByStatusOrderByDataCriacao(String status);
	
}
