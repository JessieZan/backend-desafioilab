package com.durodecodar.desafioilab.dto;

import com.durodecodar.desafioilab.model.Cliente;

public class ClienteDTO {
	private Integer id;
	private String nome;

	public ClienteDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static ClienteDTO fromCliente(Cliente c) {
		return new ClienteDTO(c.getId(), c.getNome());
	}
}
