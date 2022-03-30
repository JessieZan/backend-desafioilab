package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.durodecodar.desafioilab.dto.PedidoDTO;

public interface IPedidoServices {

	public List<PedidoDTO> listarTodosPedidos();

	public PedidoDTO buscarPedidoPorId(Integer idPedido);

	public List<PedidoDTO> listaPedidosEmAberto(String Status);
	
	public ResponseEntity<?> alterarStatusGenerico(Integer id, String acao, Integer idEntregador);

	ResponseEntity<?> listarCoordenadasPedido(Integer id);

}
