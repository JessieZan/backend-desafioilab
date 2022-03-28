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
	public List<PedidoDTO> listaPedidosEmAberto() {
		return pedidoDao.listaPedidosEmAberto();
		// return (List<PedidoDTO>)dao.listaPedidosEmAberto();
	}

	@Override
	public List<PedidoDTO> listarTodosPedidos() {
		List<PedidoDTO> pedidos = pedidoDao.listaTodosPedidos();
		System.err.println(pedidos);
		return pedidos;
	}

	@Override
	public PedidoDTO buscarPedidoPorId(Integer idPedido) {
		return pedidoDao.buscarPedidoPorId(idPedido);
	}

//	@Override
//	public Pedido adicionarPedido(Pedido pedido) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public boolean removerPedido(Integer id) {
//		try {
//			dao.deleteById(id);
//			return true;
//		} catch (Exception ex) {
//			return false;
//		}
//	}

	@Override
	public Pedido atualizarStatusPedidoEmAndamento(Pedido pedido) {
		Optional<Pedido> pedidoExiste = pedidoDao.findById(pedido.getId());

		if (pedidoExiste.isEmpty()) {
			return null;
		}
		pedido.setStatus("em_andamento");
		pedidoDao.save(pedido);
		return pedido;

	}

	public ResponseEntity<?> listarCoordenadasPedido(Integer id) {
		return ResponseEntity.ok(pedidoDao.listarCoordenadasPedido(id));
	}

	@Override
	public ResponseEntity<?> atribuirEntregadorAoPedido(Integer idPedido, Integer entregadorId) {
		Pedido pedido = pedidoDao.findById(idPedido).orElse(null);

		if (pedido != null) {

			Entregador entregador = entregadorDao.findById(entregadorId).orElse(null);

			entregador.setEmEntrega(true);
			entregadorDao.save(entregador);
			pedido.setEntregador(entregador);
			pedido.setStatus("em_andamento");
			pedidoDao.save(pedido);
			return ResponseEntity.ok(pedido);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarStatusPedidoCancelado(Integer idPedido, Integer entregadorId) {
		Pedido pedido = pedidoDao.findById(idPedido).orElse(null);

		if (pedido != null) {

			Entregador entregador = entregadorDao.findById(entregadorId).orElse(null);

			entregador.setEmEntrega(false);
			entregadorDao.save(entregador);
			pedido.setEntregador(entregador);
			pedido.setStatus("em_aberto");
			pedidoDao.save(pedido);
			return ResponseEntity.ok(pedido);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> atualizarStatusPedidoFinalizado(Integer idPedido, Integer entregadorId) {
		Pedido pedido = pedidoDao.findById(idPedido).orElse(null);

		if (pedido != null) {

			Entregador entregador = entregadorDao.findById(entregadorId).orElse(null);

			entregador.setEmEntrega(false);
			entregadorDao.save(entregador);
			pedido.setEntregador(entregador);
			pedido.setStatus("concluido");
			pedidoDao.save(pedido);
			return ResponseEntity.ok(pedido);
		}
		return null;
	}

}
