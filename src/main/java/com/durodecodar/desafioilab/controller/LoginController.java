package com.durodecodar.desafioilab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;

@RestController
@CrossOrigin("*")
public class LoginController {
	
	//@Autowired
	//private IUsuarioService service;
	
	//@PostMapping("/login")
	//public ResponseEntity<?> postLogin(@RequestBody EntregadorLoginDTO dadosLogin){
		//Token t = service.createTokenDeUsuarioLogado(dadosLogin);
		//if(t != null) {
			//return ResponseEntity.ok(t);
		//};
		
		//return ResponseEntity.status(400).body("Dados inválidos!");
		
	//}
}
