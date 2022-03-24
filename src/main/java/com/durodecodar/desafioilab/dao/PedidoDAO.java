package com.durodecodar.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.dto.PedidoDTO;

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
    + "											 cliente.id,"
    + "											 cliente.nome)"
	 + " FROM "
    + "Pedido as pedido "
    + "INNER JOIN com.durodecodar.desafioilab.dto.EntregadorDTO as entregador ON pedido.status ='em_aberto' "
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
		     + "Pedido as pedido  "
		     + "INNER JOIN com.durodecodar.desafioilab.dto.EntregadorDTO as entregador ON pedido.entregador.id = entregador.id"
		     + "INNER JOIN com.durodecodar.desafioilab.dto.ClienteDTO as cliente ON pedido.cliente.id = cliente.id AND pedido.id = :id")
	public PedidoDTO buscarPedidoPorId(@Param("id") Integer numero);


}
