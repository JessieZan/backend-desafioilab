package com.durodecodar.desafioilab.dto;

import org.springframework.beans.factory.annotation.Value;

import com.durodecodar.desafioilab.model.Entregador;

public class EntregadorDTO {
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private Boolean emEntrega;
		
	public EntregadorDTO(Integer id, String nome, String email, String telefone,Boolean emEntrega) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.emEntrega = emEntrega;
	}
	
	public EntregadorDTO(Entregador entregador) {
		super();
		this.id = entregador.getId();
		this.nome = entregador.getNome();
		this.email = entregador.getEmail();
		this.telefone = entregador.getTelefone();
		this.emEntrega = entregador.isEmEntrega();
	}
	public EntregadorDTO() {
		super();

	}
	
	public Boolean getEmEntrega() {
		return emEntrega;
	}

	public void setEmEntrega(Boolean emEntrega) {
		this.emEntrega = emEntrega;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public static EntregadorDTO fromEntregador(Entregador e) {
		return new EntregadorDTO(e.getId(), e.getNome(), e.getEmail(), e.getTelefone(),e.isEmEntrega());
	}
}	
