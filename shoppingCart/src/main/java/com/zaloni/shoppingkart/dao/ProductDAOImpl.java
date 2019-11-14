package com.zaloni.shoppingkart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;

@Repository
@Transactional
public class ProductDAOImpl implements IProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;

	@SuppressWarnings("deprecation")
	public List<Product> fetchAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> products=(List<Product>) criteria.list();
		if (products!=null) 
            return products;
		return null;
	} 

	@SuppressWarnings("deprecation")
	public Product fetchProductbyId(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("id",id));
		Product product=(Product)criteria.uniqueResult();
		return product;
	}

	public boolean addToCart(Cart cart) {
		
		template.save(cart);

		return true;
	}

	public boolean addProduct(Product product) {
		template.save(product);
		return true;
	}

	public Cart fetchCartbyId(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("id",cartId));
		Cart cart=(Cart)criteria.uniqueResult();
		return cart;
	}

	public boolean deleteCart(Cart cart) {
		template.delete(cart);
		return true;
	}

	public boolean deleteProduct(Product product) {
		template.delete(product);
		return true;
	}

	public boolean order(Order order) {
		template.save(order);
		return true;
	}

	public User fetchOrder(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
