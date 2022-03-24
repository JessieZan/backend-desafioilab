package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.dto.PedidoDTO;

//@Service
@Component
@Primary
public class PedidoServiceImpl implements IPedidoServices{

	@Autowired
	private PedidoDAO dao;
	
	@Override
	public List<PedidoDTO> listaPedidosEmAberto() {
		return dao.listaPedidosEmAberto();
		//return (List<PedidoDTO>)dao.listaPedidosEmAberto();
	}
	@Override
	public List<PedidoDTO> listarTodosPedidos() {
		List<PedidoDTO> pedidos = dao.listaTodosPedidos();
		System.err.println(pedidos);
		return pedidos ;
	}
	
	@Override
	public PedidoDTO buscarPedidoPorId(Integer id) {
		return dao.buscarPedidoPorId(id);
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


//	@Override
//	public List<PedidoDTO> listarTodosPedidos() {
//		return dao.listaTodosPedidos(); 
////		List<PedidoDTO> pedidos = (List<Pedido>) dao.listaTodosPedidos();
////		return pedidos;
//	}
	

//	@Override
//	public ResponseEntity<?> buscarPedidoPorId(Integer idPedido) {
//		Pedido pedido = dao.findById(idPedido).orElse(null);
//		if(pedido != null) {
//			return ResponseEntity.ok(pedido);
//		}
//		return ResponseEntity.status(400).body(new Mensagem(400, "Pedido nao encontrado"));
//	}
	
	



}
