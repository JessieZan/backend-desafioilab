package com.durodecodar.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.durodecodar.desafioilab.security.Token;
import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;
import com.durodecodar.desafioilab.services.IEntregadorService;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private IEntregadorService service;

	@PostMapping("/login")
	public ResponseEntity<?> realizarLogin(@RequestBody EntregadorLoginDTO dadosLogin) {
		Token token = service.gerarTokenEntregador(dadosLogin);

		if (token != null) {
			return ResponseEntity.ok(token);
		}

		return ResponseEntity.status(401).body("Acesso Negado");

	}
}
