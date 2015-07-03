package net.tmez030.springjpa.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
public class Product implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="products")
	private Set<Order> orders;

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> aOrders) {
		orders = aOrders;
	}

	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer aId) {
		id = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}   

   
}
