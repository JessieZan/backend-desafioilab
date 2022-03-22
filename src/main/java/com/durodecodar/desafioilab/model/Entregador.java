package com.durodecodar.desafioilab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "entregador")
public class Entregador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "telefone", nullable = false, length = 12, unique = true )
	private String telefone;
	
	@Column(name = "senha", nullable = false, columnDefinition = "TEXT")
	private String senha;
	
	@Column(name = "em_entrega")
	private boolean emEntrega;
	
	@OneToMany(mappedBy = "entregador")
	@JsonIgnoreProperties("entregador")
	private List<Pedido> listaDePedidos;
	
	public Entregador() {
		super();
	}
	
	public Entregador(Integer id, String nome, String email, String telefone, String senha, boolean emEntrega,
			List<Pedido> listaDePedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.emEntrega = emEntrega;
		this.listaDePedidos = listaDePedidos;
	}


	public List<Pedido> getListaDePedidos() {
		return listaDePedidos;
	}

	public void setListaDePedidos(List<Pedido> listaDePedidos) {
		this.listaDePedidos = listaDePedidos;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEmEntrega() {
		return emEntrega;
	}

	public void setEmEntrega(boolean emEntrega) {
		this.emEntrega = emEntrega;
	}

	
}
