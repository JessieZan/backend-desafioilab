package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Pedido;

public interface IPedidoServices {

	public List<PedidoDTO> listarTodosPedidos();

	public PedidoDTO buscarPedidoPorId(Integer idPedido);

	public List<PedidoDTO> listaPedidosEmAberto();

	public ResponseEntity<?> atualizarStatusPedidoCancelado(Integer idPedido, Integer entregadorId);
	public ResponseEntity<?> atualizarStatusPedidoFinalizado(Integer idPedido, Integer entregadorId);

	public ResponseEntity<?> atribuirEntregadorAoPedido(Integer pedidoId, Integer entregadorId);

	ResponseEntity<?> listarCoordenadasPedido(Integer id);

}
