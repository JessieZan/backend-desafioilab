package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dto.PedidoDTO;
import com.durodecodar.desafioilab.model.Pedido;
import com.durodecodar.desafioilab.services.IPedidoServices;
import com.durodecodar.desafioilab.util.Mensagem;

@RestController
@CrossOrigin("*")
public class PedidoController {

		@Autowired
		private IPedidoServices service;
		
		
		@GetMapping("/pedidos/em-aberto")
		public List<PedidoDTO> recuperarTodos(){
			return (List<PedidoDTO>)service.listaPedidosEmAberto();
		}
		
		@GetMapping("/pedidos")
		public ResponseEntity<List<PedidoDTO>> listarTodosPedidos(){ 
			return ResponseEntity.ok(service.listarTodosPedidos());
		}
		
		@GetMapping("/pedidos/{idPedido}")
		public ResponseEntity<?> buscarPedidoPorId(Integer idPedido) {
			PedidoDTO pedido = service.buscarPedidoPorId(idPedido);
			System.err.println(pedido);
			if(pedido != null) {
				return ResponseEntity.ok(pedido);
			}
			return ResponseEntity.status(400).body(new Mensagem(400, "Pedido nao encontrado"));
		}
		
//		@GetMapping("/pedidos/{idPedido}")
//		public ResponseEntity<?> buscarPorId(@PathVariable Integer idPedido){
//			return service.buscarPedidoPorId(idPedido);
//		}
		
		
//		@DeleteMapping("/pedidos/{id}")
//		public ResponseEntity<?> removerPedido(@PathVariable Integer id){
//			if (service.removerPedido(id)) {
//				return ResponseEntity.ok(new Mensagem(1000,"Pedido removido com sucesso"));
//			}
//			return ResponseEntity.badRequest().body(new Mensagem(9845,"Erro ao remover pedido"));
//		}
		
		
		
}