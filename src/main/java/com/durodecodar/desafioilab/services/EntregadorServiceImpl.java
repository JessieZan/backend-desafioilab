package com.durodecodar.desafioilab.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.dto.EntregadorDTO;
import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;
import com.durodecodar.desafioilab.model.Entregador;
import com.durodecodar.desafioilab.security.Encrypt;
import com.durodecodar.desafioilab.security.Token;
import com.durodecodar.desafioilab.security.TokenUtils;

@Component
@Primary
public class EntregadorServiceImpl implements IEntregadorService {
	@Autowired
	private EntregadorDAO dao;

	@Override
	public List<EntregadorDTO> recuperarTodos() {
		return dao.recuperarTodos();
	}

	@Override
	public EntregadorDTO recuperarPeloId(Integer id) {
		return dao.recuperarPeloId(id);
	}

	@Override
	public Token gerarTokenEntregador(EntregadorLoginDTO dadosLogin) {
		try {
			Entregador user = dao.findByEmailOrTelefone(dadosLogin.getEmail(), dadosLogin.getTelefone());
			if (user != null) {

				String senhaLogin = Encrypt.encrypt(dadosLogin.getSenha());

				if (user.getSenha().equals(dadosLogin.getSenha())) {
					return new Token(TokenUtils.createToken(user));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
