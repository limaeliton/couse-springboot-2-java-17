package com.educandowebcouse.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Payment implements Serializable {
	// Serializable transforma o arquivo em Json e é necessário colocar private static final long serialVersionUID = 1L;
	// JPA CONVERTE OS OBJETOS EM MODELO RELACIONAL	= @Entity
	// @Id informa que a chave primária do banco vai ser o Id
		private static final long serialVersionUID = 1L; 
	
	private long id;
	private Instant moment;
	
	private Order order;
	
	public Payment() {
		
	}

	public Payment(long id, Instant moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return id == other.id;
	}
	
	
}
