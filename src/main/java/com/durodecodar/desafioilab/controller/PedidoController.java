package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dao.PedidoDAO;
import com.durodecodar.desafioilab.model.Pedido;

@RestController
public class PedidoController {

		@Autowired
		private PedidoDAO dao;
		
		@GetMapping("/pedidos")
		public List<Pedido> recuperarTodos(){
			List<Pedido> lista;
			lista = (List<Pedido>) dao.findAll();
			return lista;
		}
}