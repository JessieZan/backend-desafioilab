package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO;
import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer>{
	
	@Query("SELECT new "
		     + "com.durodecodar.desafioilab.dto.PedidoDTO(pedido.id,"
   + "                                          pedido.dataCriacao,"
   + "                                          pedido.valorTotal,"
   + "                                          pedido.status,"
   + "                                          entregador.id,"
   + "                                          entregador.nome,"
   + "                                          entregador.email,"
   + "                                          entregador.telefone,"
   + "                                          entregador.emEntrega,"
   + "										    cliente.id,"
   + "										    cliente.nome)"
   + " FROM "
   + "Pedido as pedido INNER JOIN  Entregador as entregador ON pedido.entregador.id = entregador.id "
   + "INNER JOIN Cliente as cliente ON pedido.cliente.id = cliente.id")
	public List<PedidoDTO> listaTodosPedidos();
	
	@Query("SELECT new "
		     + "com.durodecodar.desafioilab.dto.PedidoDTO(pedido.id,"
  + "                                          pedido.dataCriacao,"
  + "                                          pedido.valorTotal,"
  + "                                          pedido.status,"
  + "                                          entregador.id,"
  + "                                          entregador.nome,"
  + "                                          entregador.email,"
  + "                                          entregador.telefone,"
  + "                                          entregador.emEntrega,"
  + "										   cliente.id,"
  + "										   cliente.nome)"
  + " FROM "
  + "Pedido as pedido INNER JOIN  Entregador as entregador ON pedido.entregador.id = entregador.id "
  + "INNER JOIN Cliente as cliente ON pedido.cliente.id = cliente.id WHERE pedido.status = 'em_aberto'")
	public List<PedidoDTO> listaPedidosEmAberto();
	
	@Query("SELECT new "
		     + "com.durodecodar.desafioilab.dto.PedidoDTO(pedido.id,"
 + "                                          pedido.dataCriacao,"
 + "                                          pedido.valorTotal,"
 + "                                          pedido.status,"
 + "                                          entregador.id,"
 + "                                          entregador.nome,"
 + "                                          entregador.email,"
 + "                                          entregador.telefone,"
 + "                                          entregador.emEntrega,"
 + "										  cliente.id,"
 + "										  cliente.nome)"
 + " FROM "
 + "Pedido as pedido INNER JOIN  Entregador as entregador ON pedido.entregador.id = entregador.id "
 + "INNER JOIN Cliente as cliente ON pedido.cliente.id = cliente.id WHERE pedido.id = :idPedido")
	public PedidoDTO buscarPedidoPorId(@Param("idPedido") Integer numero);
	
	public List<PedidoDTO> findByStatusOrderByDataCriacao(String status);
	
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
