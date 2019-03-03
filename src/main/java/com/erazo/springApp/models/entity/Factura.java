package com.erazo.springApp.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="num_factura")
	private Integer numfactura;
	
	/*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnore
	private Cliente idClient;
	*/
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fechaFactura;
	
	public Integer getNumfactura() {
		return numfactura;
	}
	public void setNumfactura(Integer numfactura) {
		this.numfactura = numfactura;
	}
	/*
	public Cliente getIdClient() {
		return idClient;
	}
	public void setIdClient(Cliente idClient) {
		this.idClient = idClient;
	}
	*/
	public Date getFecha() {
		return fechaFactura;
	}
	public void setFecha(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
	
}
