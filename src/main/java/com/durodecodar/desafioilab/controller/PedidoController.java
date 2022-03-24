package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dao.CoordenadasPedidoDAO;
import com.durodecodar.desafioilab.model.CoordenadasPedido;
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
		public List<Pedido> recuperarTodos(){
			return (List<Pedido>)service.listaPedidosEmAberto();
		}
		
		@GetMapping("/pedido")
		public ResponseEntity<List<Pedido>> listarTodosPedidos(){
			return service.listarTodosPedidos();
		}
		
		@GetMapping("/pedido/{idPedido}")
		public ResponseEntity<?> buscarPorId(@PathVariable Integer idPedido){
			return service.buscarPedidoPorId(idPedido);
		}
		
		@PutMapping("/pedido")
		public Pedido alterarStatusPedido(@RequestBody Pedido pedidoAtualizado) {
			return service.atualizarStatusPedido(pedidoAtualizado);
		}
		
		@GetMapping("/pedido/rastrear/{id}")
		public ResponseEntity<?> listarCoordenadasPedido(@PathVariable Integer id) {

			return service.listarCoordenadasPedido(id);
		}

		@PostMapping("/pedido/cadastrar-coordenada")
		public ResponseEntity<?> cadastrarCoordenada(@RequestBody List<CoordenadasPedido> listaCoordenadas) {

			listaCoordenadas.forEach(coordenadaPedido -> {
				CoordenadasPedido coordPed = new CoordenadasPedido(
								coordenadaPedido.getIdPedido(),
								coordenadaPedido.getIdEntregador(),
								coordenadaPedido.getTimestamp(),
								coordenadaPedido.getCoordenada());

				dao.save(coordPed);
			});

			return ResponseEntity.status(201).build();
		}
		
		
}