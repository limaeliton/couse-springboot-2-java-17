package com.educandowebcouse.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.educandowebcouse.entities.Order;
import com.educandowebcouse.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class OrderItemPK implements Serializable {
	// Serializable transforma o arquivo em Json e é necessário colocar private static final long serialVersionUID = 1L;
	// JPA CONVERTE OS OBJETOS EM MODELO RELACIONAL	= @Entity
	// @Id informa que a chave primária do banco vai ser o Id
		private static final long serialVersionUID = 1L; 
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
@JsonIgnore	
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
@JsonIgnore
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);

	}

}
