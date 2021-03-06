package com.durodecodar.desafioilab.model;

import java.time.LocalDateTime;

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
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "valor_total", nullable = false)
	private Integer valorTotal;

	@Column(name = "status", nullable = false, length = 10)
	private String status;

	@Column(name = "endereco_entrega", nullable = false, columnDefinition = "TEXT")
	private String enderecoEntrega;

	@ManyToOne
	@JoinColumn(name = "id_entregador")
	@JsonIgnoreProperties("listaDePedidos")
	private Entregador entregador;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	private String coordenadasPedido;

	public Pedido(String coordenadasPedido) {
		this.coordenadasPedido = coordenadasPedido;
	}

	public Pedido() {
		super();
	}

	public Pedido(LocalDateTime dataCriacao, Integer valorTotal, String status, String enderecoEntrega) {

		super();
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Pedido(Integer id, LocalDateTime dataCriacao, Integer valorTotal, String status, String enderecoEntrega,
			Integer numeroEnt, String nomeEnt, String emailEnt, String telefoneEnt, String senhaEnt,
			boolean emEntrega) {

		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.enderecoEntrega = enderecoEntrega;
		this.entregador = new Entregador();
		this.entregador.setId(numeroEnt);
		this.entregador.setNome(nomeEnt);
		this.entregador.setEmail(emailEnt);
		this.entregador.setTelefone(telefoneEnt);
		this.entregador.setSenha(senhaEnt);
		this.entregador.setEmEntrega(emEntrega);

	}

	public Cliente getCliente() {
		return cliente;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
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

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

}
