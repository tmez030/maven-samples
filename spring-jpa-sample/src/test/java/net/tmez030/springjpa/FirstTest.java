package net.tmez030.springjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.tmez030.springjpa.domain.Order;
import net.tmez030.springjpa.domain.Product;
import net.tmez030.springjpa.domain.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("/jpa-sample-context.xml")
public class FirstTest {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ProductDao dao;

	@Test
	public void test() {
		assertNotNull("Dependency injection does not seem to work!", applicationContext);
		assertNotNull("Dependency injection does not seem to work!", dao);

		Product tempProduct = new Product();
		final String tempName = "LEGO 4711";
		tempProduct.setName(tempName);
		
		Order tempOrder = new Order();
		tempOrder.setName("4711");
		
		tempProduct.setOrders(Collections.singleton(tempOrder));
		
		dao.saveProduct(tempProduct);
		
		List<Product> tempList = dao.loadProductsByCategory(tempName);
		assertEquals(1, tempList.size());
		Product tempReadProduct = tempList.get(0);
		assertNotNull(tempReadProduct.getOrders());
		assertEquals(1, tempReadProduct.getOrders().size());
		Order tempNext = tempReadProduct.getOrders().iterator().next();
		assertEquals("4711", tempNext.getName());
		
		Order tempNewOrder = new Order();
		tempNewOrder.setName("New Order");
		tempReadProduct.getOrders().add(tempNewOrder);
		dao.saveProduct(tempReadProduct);
	}

	/**
	 * Unlike the previous method we'll persist everything throw the "owning" object (here: Order).
	 */
	@Test
	public void testSavingOwningObject() {
		
	}
}
