package com.zaloni.shoppingkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.shoppingkart.dao.IProductDAO;
import com.zaloni.shoppingkart.dao.IUserDAO;
import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;

@Service
public class FetchDetailServiceImpl implements IFetchDetailService{
	
	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	IUserDAO userDAO;


	public List<Product> fetchAllProductDetails() {
		List<Product> products=productDAO.fetchAllProducts();
		if(products!=null)
		return products;
		
		return null;
	}

	public Product fetchProductDetailsById(int id) {
		Product product=productDAO.fetchProductbyId(id);
		if(product!=null)
		{
			return product;
		}
		return null;
	}

	public User fetchUserDetails(int id) {
		User user=userDAO.fetchUserDeatils(id);
		if(user!=null)
		{return user;}
		return null;
	}

	public boolean addToCart(Cart cart) {
	
		boolean result=productDAO.addToCart(cart);
		if(result)
			return true;
			return false;
	}

	public boolean addProduct(Product product) {
		
		boolean result=productDAO.addProduct(product);
		if(result)
		return true;
		return false;
	}

	public boolean addToCart(int pId, int userId) {
		Product product=productDAO.fetchProductbyId(pId);
		boolean result;
		if(product!=null)
		{
			User user=userDAO.fetchUserDeatils(userId);
			Cart cart=new Cart();
			cart.setProduct(product);
			cart.setUser(user);
			result=productDAO.addToCart(cart);
			if(result)
			return true;
		}
		return false;
	}

	public Cart fetchCartDetailsbyCartId(int cartId) {
		Cart cart=productDAO.fetchCartbyId(cartId);
		if(cart!=null)
			return cart;
		return null;
	}

	public boolean deleteCart(Cart cart) {
		boolean result=productDAO.deleteCart(cart);
		if(result)
			return true;
		return false;
	}

	public boolean deleteProduct(Product product) {
		boolean result=productDAO.deleteProduct(product);
		if(result)
			return true;
		return false;
	}

	public List<User> fetchAllUsers() {
		List<User> users=userDAO.fetchAllUsers();
		if(users!=null)
			return users;
		
		return null;
	}

	public boolean order(Order order) {

		boolean result=productDAO.order(order);	
		return result;
	}

	public User fetchOrders(int userId) {
		User user=userDAO.fetchUserOrderDetail(userId);
		if(user!=null)
		return user;
		return null;
	}

	


}
