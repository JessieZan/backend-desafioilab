package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.services.IPedidoServices;
import com.durodecodar.desafioilab.util.Mensagem;

@RestController
public class PedidoController {

		@Autowired
//		@Qualifier("dia-a-dia")
		private IPedidoServices service;
		
		@GetMapping("/pedidos/emAberto")
		public List<Pedido> recuperarTodosPedidosEmAberto(){
			return service.recuperarTodos();
		}
		
		@GetMapping("/pedidos")
		public ResponseEntity<List<Pedido>> listarTodosPedidos(){
			return service.listarTodosPedidos();
		}
		
		@GetMapping("/pedidos/{idPedido}")
		public ResponseEntity<?> buscarPorId(@PathVariable Integer idPedido){
			return service.buscarPedidoPorId(idPedido);
		}
		
//		@DeleteMapping("/pedidos/{id}")
//		public ResponseEntity<?> removerPedido(@PathVariable Integer id){
//			if (service.removerPedido(id)) {
//				return ResponseEntity.ok(new Mensagem(1000,"Pedido removido com sucesso"));
//			}
//			return ResponseEntity.badRequest().body(new Mensagem(9845,"Erro ao remover pedido"));
//		}
		
		
		
}