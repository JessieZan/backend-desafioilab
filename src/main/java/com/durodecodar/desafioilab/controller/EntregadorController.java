package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.model.Entregador;

@RestController
public class EntregadorController {

	@Autowired
	private EntregadorDAO dao;
	
	@GetMapping("/entregadores")
	public List<Entregador> retornarTodos(){
		List<Entregador> lista;
		lista = (List<Entregador>) dao.findAll();
		return lista;
	}
}
