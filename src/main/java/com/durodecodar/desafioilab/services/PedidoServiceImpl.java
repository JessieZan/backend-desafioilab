package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.dto.CoordenadasPedidoDTO;
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

	public List<CoordenadasPedidoDTO> listarCoordenadasPedido(Integer id) {
		return pedidoDao.listarCoordenadasPedido(id);
	}

	@Override
	public Pedido alterarStatusGenerico(String acao, Pedido pedido, Entregador entregador) {
		Entregador entregadorGeral = entregadorDao.findById(1).orElse(null);

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
			return null;
		}

		entregadorDao.save(entregador);

		if (acao.equals("cancelar")) {
			pedido.setEntregador(entregadorGeral);
		} else {
			pedido.setEntregador(entregador);
		}

		pedidoDao.save(pedido);
		return pedido;
	}

}
