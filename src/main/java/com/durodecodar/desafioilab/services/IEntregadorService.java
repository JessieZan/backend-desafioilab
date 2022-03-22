package com.durodecodar.desafioilab.services;

import java.util.List;

import com.durodecodar.desafioilab.dto.EntregadorDTO;

public interface IEntregadorService {
	public List<EntregadorDTO> recuperarTodos();
	public EntregadorDTO recuperarPeloId(Integer id);	
}
