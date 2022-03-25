package com.durodecodar.desafioilab.dto;

import java.time.LocalDateTime;

public class CoordenadasPedidoDTO {

	private Integer idPedido;
	private LocalDateTime timestamp;
	private String coordenada;

	public CoordenadasPedidoDTO(Integer idPedido, String coordenada, LocalDateTime timestamp) {
		this.idPedido = idPedido;
		this.timestamp = timestamp;
		this.coordenada = coordenada;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
}
