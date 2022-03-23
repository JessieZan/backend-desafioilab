package com.durodecodar.desafioilab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.security.Token;
import com.durodecodar.desafioilab.security.TokenUtils;

@Component
public class EntregadorServiceImpl implements IEntregadorService {

	@Autowired
	private EntregadorDAO dao;

	@Override
	public Token gerarTokenEntregador(EntregadorLoginDTO dadosLogin) {
		Entregador user = dao.findByEmailOrTelefone(dadosLogin.getEmail(), dadosLogin.getTelefone());
		if (user != null) {
			if (user.getSenha().equals(dadosLogin.getSenha())) {
				return new Token(TokenUtils.createToken(user));
			}
		}
		return null;
	}

}