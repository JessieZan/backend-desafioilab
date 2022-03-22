package com.durodecodar.desafioilab.dao;

import org.springframework.data.repository.CrudRepository;

import com.durodecodar.desafioilab.model.Cliente;

public interface ClienteDAO  extends CrudRepository<Cliente, Integer>{
	
}
