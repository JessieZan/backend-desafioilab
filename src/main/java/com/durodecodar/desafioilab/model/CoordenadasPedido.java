package com.durodecodar.desafioilab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rastreamento_pedido")
public class CoordenadasPedido {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "id_pedido")
  private Integer idPedido;

  @Column(name = "timestamp_vinculado")
  private LocalDateTime timestamp;

  //@OneToMany(mappedBy = "rastreamento_pedido", cascade = CascadeType.ALL)
  //@JsonIgnoreProperties("rastreamento_pedido")
  //@ElementCollection
  @Column(name = "coordenadas")
  private String coordenada;

  public CoordenadasPedido() {
    super();
  }

  public CoordenadasPedido(String coordenada, LocalDateTime timestamp) {
    this.timestamp = timestamp;
    this.coordenada = coordenada;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
