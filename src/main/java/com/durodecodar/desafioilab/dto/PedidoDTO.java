package com.durodecodar.desafioilab.dto;

import java.time.LocalDateTime;

import com.durodecodar.desafioilab.model.Pedido;

public class PedidoDTO {
	private Integer id;
	private LocalDateTime dataCriacao;
	private Integer valorTotal;
	private String status;
	private EntregadorDTO entregador;
	private ClienteDTO cliente;

	public PedidoDTO(Integer id, LocalDateTime dataCriacao, Integer valorTotal, String status, EntregadorDTO entregador,
			ClienteDTO cliente) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.entregador = entregador;
		this.cliente = cliente;
	}

	public PedidoDTO() {
		super();
		System.out.println("entrei no construtor vazio");
	}

	public PedidoDTO(Integer id, LocalDateTime dataCriacao, Integer valorTotal, String status, Integer idEntregador,
			String nomeEntegador, String emailEntegador, String telefoneEntegador, Boolean emEntrega, Integer idCliente,
			String nomeCliente) {
		super();
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.entregador = new EntregadorDTO();
		this.entregador.setId(idEntregador);
		this.entregador.setNome(nomeEntegador);
		this.entregador.setEmail(emailEntegador);
		this.entregador.setTelefone(telefoneEntegador);
		this.entregador.setEmEntrega(emEntrega);
		this.cliente = new ClienteDTO();
		this.cliente.setId(idCliente);
		this.cliente.setNome(nomeCliente);
	}

	public static PedidoDTO fromPedido(Pedido p) {
		return new PedidoDTO(p.getId(), p.getDataCriacao(), p.getValorTotal(), p.getStatus(), p.getEntregador().getId(),
				p.getEntregador().getNome(), p.getEntregador().getEmail(), p.getEntregador().getTelefone(),
				p.getEntregador().isEmEntrega(), p.getCliente().getId(), p.getCliente().getNome());
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

	public EntregadorDTO getEntregador() {
		return entregador;
	}

	public void setEntregador(EntregadorDTO entregador) {
		this.entregador = entregador;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

}
