package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.durodecodar.desafioilab.dao.ClienteDAO;
import com.durodecodar.desafioilab.model.Cliente;
import com.durodecodar.desafioilab.model.Pedido;

public class ClienteController {
	@Autowired
	private ClienteDAO dao;
	
	@GetMapping("/clientes")
	public List<Cliente> recuperarTodos() {
		return (List<Cliente>) dao.findAll();
	}
}
