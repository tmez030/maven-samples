package net.tmez030.springjpa.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Product> loadProductsByCategory(String category) {
		TypedQuery<Product> query = em.createQuery("from Product as p where p.name = ?1", Product.class);
		query.setParameter(1, category);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveProduct(Product aProduct) {
		if (aProduct.getId() == null) {
			em.persist(aProduct);
		} else {
			em.merge(aProduct);
		}
		em.flush();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Order> loadOrders(String category) {
		TypedQuery<Order> query = em.createQuery("from Order as p where p.name = ?1", Order.class);
		query.setParameter(1, category);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveOrder(Order anOrder) {
		if (anOrder.getId() == null) {
			em.persist(anOrder);
		} else {
			em.merge(anOrder);
		}
		em.flush();
	}

}