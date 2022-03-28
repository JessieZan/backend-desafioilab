package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Pedido;

public interface IPedidoServices {

//	public Pedido adicionarPedido(Pedido pedido);
//	public boolean removerPedido(Integer id);
//	public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer idPedido);
	public List<PedidoDTO> listarTodosPedidos();

	public PedidoDTO buscarPedidoPorId(Integer idPedido);

	public List<PedidoDTO> listaPedidosEmAberto();

	public Pedido atualizarStatusPedidoEmAndamento(Pedido pedido);
	public ResponseEntity<?> atualizarStatusPedidoCancelado(Integer idPedido, Integer entregadorId);
	public ResponseEntity<?> atualizarStatusPedidoFinalizado(Integer idPedido, Integer entregadorId);

	public ResponseEntity<?> atribuirEntregadorAoPedido(Integer pedidoId, Integer entregadorId);
//	List<Pedido> listaPedidosTESTANDO();

	ResponseEntity<?> listarCoordenadasPedido(Integer id);

}
