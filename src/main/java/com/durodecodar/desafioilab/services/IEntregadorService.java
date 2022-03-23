package com.durodecodar.desafioilab.services;

import com.durodecodar.desafioilab.dto.EntregadorLoginDTO;
import com.durodecodar.desafioilab.security.Token;

public interface IEntregadorService {
	public Token gerarTokenEntregador(EntregadorLoginDTO dadosLogin);

}
