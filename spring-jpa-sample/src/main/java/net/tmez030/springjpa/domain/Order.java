package net.tmez030.springjpa.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Order
 * "order" is a reserved word in SQL!!!!
 */
@Entity
@Table(name="T_ORDER")
public class Order implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Order "owns" Product
	 */
	@ManyToMany
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> aProducts) {
		products = aProducts;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
