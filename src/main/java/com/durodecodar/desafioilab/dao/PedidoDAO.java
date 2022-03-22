package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.durodecodar.desafioilab.model.Pedido;

public interface PedidoDAO  extends CrudRepository<Pedido, Integer>{
	
	@Query("SELECT new "
		     + "com.durodecodar.desafioilab.model.Pedido(pedido.id,"
     + "                                          pedido.dataCriacao,"
     + "                                          pedido.valorTotal,"
     + "                                          pedido.status,"
     + "                                          entregador.id,"
     + "                                          entregador.nome,"
     + "                                          entregador.email,"
     + "                                          entregador.telefone,"
     + "                                          entregador.senha, "
     + "                                          entregador.emEntrega)"
	 + "FROM "
     + "Pedido as pedido INNER JOIN Entregador as entregador ON entregador.id = pedido.entregador.id")
	public List<Pedido> listarTodosPedidos();
}
