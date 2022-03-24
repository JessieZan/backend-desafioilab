package com.durodecodar.desafioilab.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rastreamento_pedido")
public class CoordenadasPedido {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "id_pedido")
  private Integer idPedido;

  @Column(name = "id_entregador")
  private Integer idEntregador;

  @Column(name = "timestamp_vinculado")
  private LocalDateTime timestamp;

  @Column(name = "coordenadas")
  private String coordenada;

  public CoordenadasPedido() {
    super();
  }

  public CoordenadasPedido(Integer idPedido,String coordenada, LocalDateTime timestamp) {
    this.idPedido = idPedido;
    this.timestamp = timestamp;
    this.coordenada = coordenada;
  }

  public CoordenadasPedido(Integer idPedido, Integer idEntregador ,LocalDateTime timestamp, String coordenada) {
    this.idPedido = idPedido;
    this.idEntregador = idEntregador;
    this.timestamp = timestamp;
    this.coordenada = coordenada;
  }

  public Integer getIdEntregador() {
    return idEntregador;
  }

  public void setIdEntregador(Integer idEntregador) {
    this.idEntregador = idEntregador;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
