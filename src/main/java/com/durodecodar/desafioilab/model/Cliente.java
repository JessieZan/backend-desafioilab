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
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name="id",  nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50, unique = true)
	private String nome;

	@Column(name = "senha", nullable = false, columnDefinition = "TEXT")
	private String senha;
	
//	@OneToMany(mappedBy = "cliente")
//	@JsonIgnoreProperties("cliente")
//	private List<Pedido>listaDePedidosCliente;

	public Integer getId() {
		return id;
	}
	
	public Cliente() {
		super();
	}


	public Cliente(Integer id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public List<Pedido> getListaDePedidosCliente() {
//		return listaDePedidosCliente;
//	}
//
//	public void setListaDePedidosCliente(List<Pedido> listaDePedidosCliente) {
//		this.listaDePedidosCliente = listaDePedidosCliente;
//	}
	
	
}

