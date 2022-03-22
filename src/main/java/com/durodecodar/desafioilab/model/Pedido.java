package com.durodecodar.desafioilab.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@Column(name="id",  nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_criacao")
	private Timestamp dataCriacao;
	
	@Column(name = "valor_total", nullable = false)
	private Integer valorTotal;
	
	@Column(name = "status", nullable = false, length = 10)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_entregador")
	@JsonIgnoreProperties("listaDePedidos")
	private Entregador entregador;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	@JsonIgnoreProperties("listaDePedidosCliente")
	private Cliente cliente;

	public Pedido() {
		
	}
	
	public Pedido(
			Integer id, Timestamp dataCriacao, 
			Integer valorTotal, String status, 
			Integer numeroEnt , String nomeEnt, 
			String emailEnt, String telefoneEnt, 
			String senhaEnt, boolean emEntrega,
			Integer numeroCli, String nomeCli, String senhaCli
			) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.entregador = new Entregador();
		this.entregador.setId(numeroEnt);
		this.entregador.setNome(nomeEnt);
		this.entregador.setEmail(emailEnt);
		this.entregador.setTelefone(telefoneEnt);
		this.entregador.setSenha(senhaEnt);
		this.entregador.setEmEntrega(emEntrega);
		this.cliente = new Cliente();
		this.cliente.setId(numeroCli);
		this.cliente.setNome(nomeCli);
		this.cliente.setSenha(senhaCli);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	
}
