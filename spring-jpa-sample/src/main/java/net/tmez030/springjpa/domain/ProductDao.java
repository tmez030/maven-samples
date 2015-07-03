package net.tmez030.springjpa.domain;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {

	List<Product> loadProductsByCategory(String category);

	void saveProduct(Product aProduct);

	void saveOrder(Order aProduct);

	List<Order> loadOrders(String category);

}
