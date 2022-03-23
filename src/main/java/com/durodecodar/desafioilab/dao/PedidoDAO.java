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

	 + " FROM "
     + "Pedido as pedido INNER JOIN Entregador as entregador ON pedido.status = 'em_aberto'")
	public List<Pedido> getPedidoPorId();
	
	
	
	@Query(" SELECT "
			+ " new com.durodecodar.desafioilab.model.Pedido("
			+ "  pedido.dataCriacao,"
			+ "  pedido.valorTotal,"
			+ "  pedido.status)"
			+ "FROM Pedido as pedido WHERE pedido.status = 'em_aberto'")
	public List<Pedido> getPedidosEmAberto();

}
