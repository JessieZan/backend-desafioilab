package com.durodecodar.desafioilab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.durodecodar.desafioilab.dao.ClienteDAO;
import com.durodecodar.desafioilab.dto.ClienteDTO;

@Component
@Primary
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private ClienteDAO dao;

	@Override
	public List<ClienteDTO> recuperarTodos() {
		return dao.recuperarTodos();
	}

	@Override
	public ClienteDTO recuperarPeloId(Integer id) {
		return dao.recuperarPeloId(id);
	}
}
