package com.durodecodar.desafioilab.services;

import java.util.List;

import com.durodecodar.desafioilab.dto.EntregadorDTO;
import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;
import com.durodecodar.desafioilab.security.Token;

public interface IEntregadorService {
	public List<EntregadorDTO> recuperarTodos();

	public EntregadorDTO recuperarPeloId(Integer id);

	public Token gerarTokenEntregador(EntregadorLoginDTO dadosLogin);

}
