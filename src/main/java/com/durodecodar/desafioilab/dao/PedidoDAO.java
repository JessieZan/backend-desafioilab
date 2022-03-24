package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO;
import com.durodecodar.desafioilab.model.Pedido;

public interface PedidoDAO  extends CrudRepository<Pedido, Integer>{
	
	
	public List<Pedido> findByStatusOrderByDataCriacao(String status);
	
	@Query("SELECT new com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO(pedido.idPedido, coordenadas.coordenada, " +
			"coordenadas.timestamp)" +
			" FROM CoordenadasPedido as pedido INNER JOIN CoordenadasPedido as coordenadas on pedido.id = coordenadas.idPedido" +
			" WHERE pedido.id = :id")
	List<CoordenadasPedidoDTO> listarCoordenadasPedido(@Param("id") Integer id);
	
//	@Query("UPDATE new com.durodecodar.desafioilab.dto.PedidoDTO(pedido.idPedido, pedido.entregadorId, " +
//			" FROM Pedido as pedido INNER JOIN Entregador as entregador on pedido.id = coordenadas.idPedido" +
//			" WHERE pedido.id = :id")
//	public void atribuirEntregadorAoPedido(Integer idPedido, Integer entregadorId);
}
