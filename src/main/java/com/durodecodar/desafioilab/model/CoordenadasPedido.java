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

  @Column(name = "timestamp_vinculado")
  private LocalDateTime timestamp;

  //@OneToMany(mappedBy = "rastreamento_pedido", cascade = CascadeType.ALL)
  //@JsonIgnoreProperties("rastreamento_pedido")
  @ElementCollection
  private List<String> RastreamentoPedido;

  public CoordenadasPedido() {
    super();
  }

  public CoordenadasPedido(Integer id, LocalDateTime timestamp, List<String> rastreamentoPedido) {
    this.id = id;
    this.timestamp = timestamp;
    RastreamentoPedido = rastreamentoPedido;
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

  public List<String> getRastreamentoPedido() {
    return RastreamentoPedido;
  }

  public void setRastreamentoPedido(List<String> rastreamentoPedido) {
    RastreamentoPedido = rastreamentoPedido;
  }


}
