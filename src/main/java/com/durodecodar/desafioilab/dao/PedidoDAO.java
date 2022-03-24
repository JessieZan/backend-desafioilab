package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.model.CoordenadasPedido;

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
	public Pedido  buscarPedidoPorId();
	
	
	
	@Query(" SELECT "
			+ " new com.durodecodar.desafioilab.model.Pedido("
			+ "  pedido.dataCriacao,"
			+ "  pedido.valorTotal,"
			+ "  pedido.status)"
			+ "FROM Pedido as pedido WHERE pedido.status = 'em_aberto'")
	public List<Pedido> listaPedidosEmAberto();

	@Query("SELECT new com.durodecodar.desafioilab.model.Pedido( " +
					" pedido.valorTotal," +
					" pedido.status," +
					" pedido.coordenadasPedido) FROM Pedido as pedido INNER JOIN CoordenadasPedido as coordenadas on pedido.id = coordenadas.idPedido")
	public List<CoordenadasPedido> listarCoordenadasPedido();

}
