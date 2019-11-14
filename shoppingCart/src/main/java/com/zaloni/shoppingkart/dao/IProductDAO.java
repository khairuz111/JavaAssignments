package com.zaloni.shoppingkart.dao;

import java.util.List;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;


public interface IProductDAO {

	public List<Product> fetchAllProducts();
	public Product fetchProductbyId(int id);
	public boolean addToCart(Cart cart);
	public boolean addProduct(Product product);
	public Cart fetchCartbyId(int cartId);
	public boolean deleteCart(Cart cart);
	public boolean deleteProduct(Product product);
	public boolean order(Order order);
	public User fetchOrder(int userId);
}
