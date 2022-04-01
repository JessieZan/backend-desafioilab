package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dto.ClienteDTO;
import com.durodecodar.desafioilab.services.IClienteService;

@RestController
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private IClienteService service;

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> recuperarTodos() {
		return ResponseEntity.ok(service.recuperarTodos());
	}

	@GetMapping("/clientes/{idCliente}")
	public ResponseEntity<ClienteDTO> recuperarPeloId(@PathVariable Integer idCliente) {
		ClienteDTO res = service.recuperarPeloId(idCliente);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

}