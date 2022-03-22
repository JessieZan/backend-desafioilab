package com.durodecodar.desafioilab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.dto.EntregadorDTO;
import com.durodecodar.desafioilab.services.IEntregadorService;

@RestController
@CrossOrigin("*")
public class EntregadorController {

	@Autowired
	private IEntregadorService service;
	
	@GetMapping("/entregadores")
	public  ResponseEntity<List<EntregadorDTO>> retornarTodos(){
		return ResponseEntity.ok(service.recuperarTodos());
	}
	
	@GetMapping("/entregadores/{id}")
	public ResponseEntity<EntregadorDTO> recuperarPeloId(@PathVariable Integer id){
		EntregadorDTO res = service.recuperarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
}
