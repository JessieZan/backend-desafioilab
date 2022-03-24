package com.durodecodar.desafioilab.dao;

import java.util.List;

import com.durodecodar.desafioilab.model.CoordenadasPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO;

import org.springframework.data.repository.query.Param;

public interface PedidoDAO extends CrudRepository<Pedido, Integer>{
	
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

	@Query("SELECT new com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO(pedido.idPedido, coordenadas.coordenada, " +
					"coordenadas.timestamp)" +
					" FROM CoordenadasPedido as pedido INNER JOIN CoordenadasPedido as coordenadas on pedido.id = coordenadas.idPedido" +
					" WHERE pedido.id = :id")
	List<CoordenadasPedidoDTO> listarCoordenadasPedido(@Param("id") Integer id);



}
