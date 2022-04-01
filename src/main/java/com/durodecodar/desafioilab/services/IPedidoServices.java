package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO;
import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.model.Pedido;

public interface IPedidoServices {

	public List<PedidoDTO> listarTodosPedidos();

	public PedidoDTO buscarPedidoPorId(Integer idPedido);

	public List<PedidoDTO> listaPedidosEmAberto(String Status);
	
	public Pedido alterarStatusGenerico(String acao, Pedido pedido, Entregador entregador);

	public List<CoordenadasPedidoDTO> listarCoordenadasPedido(Integer id);

}
