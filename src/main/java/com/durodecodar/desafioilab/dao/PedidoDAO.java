package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.dto.PedidoDTO;

public interface PedidoDAO  extends CrudRepository<Pedido, Integer>{
	
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
   + "Pedido as pedido INNER JOIN Entregador as entregador "
   + "INNER JOIN Cliente as cliente")
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
    + "											 cliente.id,"
    + "											 cliente.nome)"
	 + " FROM "
    + "Pedido as pedido "
    + "INNER JOIN com.durodecodar.desafioilab.dto.EntregadorDTO as entregador ON pedido.status = 'em_aberto' "
    + "INNER JOIN com.durodecodar.desafioilab.dto.ClienteDTO as cliente")
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
		     + "Pedido as pedido INNER JOIN com.durodecodar.desafioilab.model.Pedido as pedido "
		     + "INNER JOIN com.durodecodar.desafioilab.dto.EntregadorDTO as entregador INNER JOIN com.durodecodar.desafioilab.dto.ClienteDTO as cliente ON pedido.id = :id")
	public PedidoDTO buscarPedidoPorId(@Param("id") Integer numero);
	
//	@Query("SELECT new "
//		     + "com.durodecodar.desafioilab.dto.PedidoDTO(pedido.id,"
//     + "                                          pedido.dataCriacao,"
//     + "                                          pedido.valorTotal,"
//     + "                                          pedido.status,"
//     + "                                          entregador.id,"
//     + "                                          entregador.nome,"
//     + "                                          entregador.email,"
//     + "                                          entregador.telefone,"
//     + "                                          entregador.emEntrega)"
//	 + " FROM "
//     + "Pedido as pedido INNER JOIN Entregador as entregador ON pedido.status = 'em_aberto'")
//	public PedidoDTO buscarPedidoPorId();
//	
//	
//	
//	@Query(" SELECT "
//			+ " new com.durodecodar.desafioilab.dto.PedidoDTO("
//			+ "  pedido.dataCriacao,"
//			+ "  pedido.valorTotal,"
//			+ "  pedido.status)"
//			+ "FROM Pedido as pedido WHERE pedido.status = 'em_aberto'")
//	public List<PedidoDTO> listaPedidosEmAberto();

}
