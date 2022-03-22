package com.durodecodar.desafioilab.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rastreamento_pedido")
public class CoordenadasPedido {
	@Id
	@Column(name="id",  nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "timestamp_vinculado")
	private Timestamp timestampVinculado;
	
	@Column(name = "latitude", nullable = false)
	private String latitude;
	
	@Column(name = "longitude", nullable = false)
	private String longitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTimestampVinculado() {
		return timestampVinculado;
	}

	public void setTimestampVinculado(Timestamp timestampVinculado) {
		this.timestampVinculado = timestampVinculado;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public CoordenadasPedido(Timestamp timestampVinculado, String latitude, String longitude) {
		super();
		this.timestampVinculado = timestampVinculado;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public CoordenadasPedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
