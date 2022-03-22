package com.durodecodar.desafioilab.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.durodecodar.desafioilab.dao.EntregadorDAO;
import com.durodecodar.desafioilab.dto.EntregadorDTO;
import com.durodecodar.desafioilab.model.Entregador;


@Component
@Primary
public class EntregadorServiceImpl implements IEntregadorService{
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
	
}
