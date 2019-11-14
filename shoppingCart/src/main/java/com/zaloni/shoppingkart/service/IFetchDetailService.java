package com.zaloni.shoppingkart.service;

import java.util.List;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;


public interface IFetchDetailService {
	public List<Product> fetchAllProductDetails();
	public Product fetchProductDetailsById(int Id);
	public User fetchUserDetails(int id);
	public boolean addToCart(int pId,int userId);
	public boolean addProduct(Product product);
	public Cart fetchCartDetailsbyCartId(int cartId);
	public boolean deleteCart(Cart cart);
	public boolean deleteProduct(Product product);
	public List<User> fetchAllUsers();
	public boolean order(Order order);
	public User fetchOrders(int userId);
}
