package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dao.CoordenadasPedidoDAO;
import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.CoordenadasPedido;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.services.IPedidoServices;
import com.durodecodar.desafioilab.util.Mensagem;

@RestController
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private IPedidoServices service;

	@Autowired
	private CoordenadasPedidoDAO dao;

	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> listarTodosPedidos(@RequestParam(required = false) String status) {
		if (status != null) {
			return ResponseEntity.ok().body(service.listaPedidosEmAberto(status));
		}
		return ResponseEntity.ok(service.listarTodosPedidos());
	}

	@GetMapping("/pedidos/{idPedido}")
	public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer idPedido) {
		PedidoDTO pedido = service.buscarPedidoPorId(idPedido);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		}
		return ResponseEntity.status(400).body(new Mensagem(400, "Pedido nao encontrado"));
	}

	@PutMapping("/pedidos/{id}")
	public ResponseEntity<?> alterarStatusGenerico(@PathVariable Integer id, @RequestParam String acao,
			@RequestParam Integer idEntregador) {
		return service.alterarStatusGenerico(id, acao, idEntregador);
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

}