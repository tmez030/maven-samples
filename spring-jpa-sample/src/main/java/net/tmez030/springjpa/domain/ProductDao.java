package net.tmez030.springjpa.domain;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {

	/**
	 * Loads all products by category.
	 * 
	 * @param category name of category
	 * @return list of products
	 */
	List<Product> loadProductsByCategory(String category);

	/**
	 * Saves aProduct
	 * @param aProduct to be saved
	 */
	void saveProduct(Product aProduct);

	/**
	 * Saves an order
	 * 
	 * @param aProduct to be saved
	 */
	void saveOrder(Order aProduct);

	/**
	 * Loads all orders.
	 * 
	 * @param category name of category
	 * @return list of orders
	 */
	List<Order> loadOrders(String category);

}
