package com.durodecodar.desafioilab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.model.Pedido;

@Component
@Primary
public class PedidoServiceImpl implements IPedidoServices {

	@Autowired
	private PedidoDAO pedidoDao;

	@Autowired
	private EntregadorDAO entregadorDao;

	@Override
	public List<PedidoDTO> listaPedidosEmAberto(String status) {
		return pedidoDao.listaPedidosEmAberto(status);
	}

	@Override
	public List<PedidoDTO> listarTodosPedidos() {
		List<PedidoDTO> pedidos = pedidoDao.listaTodosPedidos();
		return pedidos;
	}

	@Override
	public PedidoDTO buscarPedidoPorId(Integer idPedido) {
		return pedidoDao.buscarPedidoPorId(idPedido);
	}

	public ResponseEntity<?> listarCoordenadasPedido(Integer id) {
		return ResponseEntity.ok(pedidoDao.listarCoordenadasPedido(id));
	}

	@Override
	public ResponseEntity<?> alterarStatusGenerico(Integer id, String acao, Integer idEntregador) {
		Pedido pedido = pedidoDao.findById(id).orElse(null);
		Entregador entregador = entregadorDao.findById(idEntregador).orElse(null);

		if (pedido == null || entregador == null) {
			return ResponseEntity.notFound().build();
		}

		if (acao.equals("atribuir")) {
			entregador.setEmEntrega(true);
			pedido.setStatus("em_andamento");
		} else if (acao.equals("cancelar")) {
			entregador.setEmEntrega(false);
			pedido.setStatus("em_aberto");
		} else if (acao.equals("finalizar")) {
			entregador.setEmEntrega(false);
			pedido.setStatus("concluido");
		} else {
			return ResponseEntity.badRequest().build();
		}

		entregadorDao.save(entregador);
		pedido.setEntregador(entregador);
		pedidoDao.save(pedido);
		return ResponseEntity.ok(pedido);
	}

}
