package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.durodecodar.desafioilab.model.Pedido;

public interface IPedidoServices {

	public ResponseEntity<List<Pedido>> listarTodosPedidos();

	public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer idPedido);

	List<Pedido> listaPedidosEmAberto();

	public Pedido atualizarStatusPedido(Pedido pedido);

	public ResponseEntity<?> atribuirEntregadorAoPedido(Integer pedidoId, Integer entregadorId);

//	List<Pedido> listaPedidosTESTANDO();

	ResponseEntity<?> listarCoordenadasPedido(Integer id);

}
