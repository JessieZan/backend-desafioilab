package com.durodecodar.desafioilab.services;

import java.util.List;

import com.durodecodar.desafioilab.dto.ClienteDTO;

public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();

	public ClienteDTO recuperarPeloId(Integer id);
}
