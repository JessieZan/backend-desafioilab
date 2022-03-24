package com.durodecodar.desafioilab.controller;

import java.util.List;

import com.durodecodar.desafioilab.dao.CoordenadasPedidoDAO;
import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.model.CoordenadasPedido;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.services.IPedidoServices;
import com.durodecodar.desafioilab.util.Mensagem;

@RestController
@CrossOrigin("*")
public class PedidoController {

		@Autowired
//		@Qualifier("dia-a-dia")
		private IPedidoServices service;

		@Autowired
		private CoordenadasPedidoDAO dao;

		@GetMapping("/pedidos/em-aberto")
		public List<Pedido> recuperarTodos(){
			return (List<Pedido>)service.listaPedidosEmAberto();
		}
		
		@GetMapping("/pedidos")
		public ResponseEntity<List<Pedido>> listarTodosPedidos(){
			return service.listarTodosPedidos();
		}
		
		@GetMapping("/pedidos/{idPedido}")
		public ResponseEntity<?> buscarPorId(@PathVariable Integer idPedido){
			return service.buscarPedidoPorId(idPedido);
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

//		@DeleteMapping("/pedidos/{id}")
//		public ResponseEntity<?> removerPedido(@PathVariable Integer id){
//			if (service.removerPedido(id)) {
//				return ResponseEntity.ok(new Mensagem(1000,"Pedido removido com sucesso"));
//			}
//			return ResponseEntity.badRequest().body(new Mensagem(9845,"Erro ao remover pedido"));
//		}
		
		
		
}