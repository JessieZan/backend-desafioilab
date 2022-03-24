package com.durodecodar.desafioilab.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class CoordenadaPedidoDTO {

  private Integer idPedido;

  private LocalDateTime timestamp;

  private String coordenada;

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
