package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.dao.CoordenadasPedidoDAO;
import com.durodecodar.desafioilab.model.CoordenadasPedido;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.services.IPedidoServices;
import com.durodecodar.desafioilab.util.Mensagem;

@RestController
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private IPedidoServices service;

	@Autowired
	private CoordenadasPedidoDAO dao;

	@GetMapping("/pedidos/em-aberto")
	public List<PedidoDTO> recuperarTodos() {
		return (List<PedidoDTO>) service.listaPedidosEmAberto();
	}

	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> listarTodosPedidos() {
		return ResponseEntity.ok(service.listarTodosPedidos());
	}

	@GetMapping("/pedidos/{idPedido}")
	public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer idPedido) {
		PedidoDTO pedido = service.buscarPedidoPorId(idPedido);
		System.err.println(pedido);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		return ResponseEntity.status(400).body(new Mensagem(400, "Pedido nao encontrado"));
	}

//		@DeleteMapping("/pedidos/{id}")
//		public ResponseEntity<?> removerPedido(@PathVariable Integer id){
//			if (service.removerPedido(id)) {
//				return ResponseEntity.ok(new Mensagem(1000,"Pedido removido com sucesso"));
//			}
//			return ResponseEntity.badRequest().body(new Mensagem(9845,"Erro ao remover pedido"));
//		}

	@PutMapping("/pedidos/{id}")
	public Pedido alterarStatusPedidoAtribuirEntregador(@RequestBody Pedido pedidoAtualizado) {

		return service.atualizarStatusPedido(pedidoAtualizado);
	}

	@GetMapping("/pedidos/rastrear/{id}")
	public ResponseEntity<?> listarCoordenadasPedido(@PathVariable Integer id) {

		return service.listarCoordenadasPedido(id);
	}

	@PostMapping("/pedidos/cadastrar-coordenada")
	public ResponseEntity<?> cadastrarCoordenada(@RequestBody CoordenadasPedido listaCoordenadas) {

			dao.save(listaCoordenadas);
			return ResponseEntity.status(201).build();
	}

	@PutMapping("/pedidos/atribuir/{id}")
	public ResponseEntity<?> atribuirPedidoAoEntregador(@PathVariable Integer id, @RequestBody Entregador entregador) {
		service.atribuirEntregadorAoPedido(id, entregador.getId());
		return ResponseEntity.status(201).build();
	}

}