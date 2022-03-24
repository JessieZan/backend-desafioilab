package com.durodecodar.desafioilab.services;

import java.util.List;

import com.durodecodar.desafioilab.model.CoordenadasPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.util.Mensagem;

@Service
@Component
public class PedidoServiceImpl implements IPedidoServices{

	@Autowired
	private PedidoDAO dao;
	
	@Override
	public Pedido adicionarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean removerPedido(Integer id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public List<Pedido> listaPedidosEmAberto() {
		return (List<Pedido>)dao.listaPedidosEmAberto();
	}

	@Override
	public ResponseEntity<List<Pedido>> listarTodosPedidos() {
		List<Pedido> pedidos = (List<Pedido>) dao.findAll();
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> buscarPedidoPorId(Integer idPedido) {
		Pedido pedido = dao.findById(idPedido).orElse(null);
		if(pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		return ResponseEntity.status(400).body(new Mensagem(400, "Pedido nao encontrado"));
	}

	/*public ResponseEntity<List<Pedido>> listarCoordenadasPedido(Integer id) {
		return ResponseEntity.ok(dao.listarCoordenadasPedido(id));
		//return dao.listarCoordenadasPedido(id);
	}*/

	public ResponseEntity<?> listarCoordenadasPedido(Integer id) {
		return ResponseEntity.ok(dao.listarCoordenadasPedido(id));
	}
	


}
