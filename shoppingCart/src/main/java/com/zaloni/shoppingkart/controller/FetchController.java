package com.zaloni.shoppingkart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;
import com.zaloni.shoppingkart.service.IFetchDetailService;

@Controller
@SessionAttributes({ "name", "userId" })
public class FetchController {

	@Autowired
	private IFetchDetailService fetchDetailService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView fetchProfilDetails(@ModelAttribute("userId") int userId, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView();
		User user = fetchDetailService.fetchUserDetails(userId);
		if (user != null) {
			modelView.addObject("userId", user.getUserId());
			modelView.addObject("name",user.getName());
			modelView.addObject("username", user.getUsername());
			modelView.addObject("age", user.getAge());
			modelView.addObject("gender", user.getGender());
			modelView.addObject("address",user.getAddress());
			modelView.setViewName("profile");
			return modelView;
		} else {
			modelView.addObject("ErrorMessage", "Unable to Display user details");
			modelView.setViewName("productPage");
			return modelView;
		}

	}

	@RequestMapping(value = "/cartDetails")
	public ModelAndView fetchCartDetail(@ModelAttribute("userId") int userId, HttpServletRequest req,@ModelAttribute("deleteSuccess") String sMessage
			,@ModelAttribute("deleteError") String eMessage) {
		ModelAndView mv= new ModelAndView();
		User user= fetchDetailService.fetchUserDetails(userId);
		int sum=0;
		
		if(user!=null) {
			List<Product> products=new ArrayList<Product>();
			for(Cart c:user.getCart())
			{
				products.add(c.getProduct());
				sum=sum+c.getProduct().getpPrice();
			}
			if(sMessage.equals("1")) {mv.addObject("deleteSuccess", "ITEM SUCCESSFULLY DELETED");}
			if(eMessage.equals("0")) {mv.addObject("deleteError", "ITEM CANNOT BE DELETED");}
			mv.addObject("cartList", user.getCart());
			mv.addObject("total", sum);
			mv.addObject("productList", products);
			mv.setViewName("cartPage");
		
			return mv;
		}
		else
		{
			mv.addObject("errorMessage","Sorry Item unvailable");
			mv.setViewName("productPage");
			return mv;
		}
	}

	@RequestMapping(value = "/adminHome")
	public ModelAndView fetchProductForAdmin(@ModelAttribute("name") String name,@ModelAttribute("productAdded") String message,
			@ModelAttribute("deleteSuccess") String dMessage,@ModelAttribute("deleteError") String eMessage) {

		ModelAndView mv = new ModelAndView();
		List<Product> products = fetchDetailService.fetchAllProductDetails();
		if(message.equals("1")) {mv.addObject("addingSuccess", "ITEM WAS SUCCESSFULLY ADDED");}
		if(dMessage.equals("1")) {mv.addObject("deleteSuccess", "ITEM WAS SUCCESSFULLY DELETED");}
		if(eMessage.equals("0")) {mv.addObject("deleteError", "ITEM WAS NOT DELETED");}
		mv.addObject("productList", products);
		mv.addObject("name", name);
		mv.setViewName("adminProductPage"); 
		return mv;

	}

	@RequestMapping(value = "/allProducts")
	public ModelAndView fetchAllProducts(@ModelAttribute("userId") int userId, @ModelAttribute("name") String name,
			HttpServletRequest req,@ModelAttribute ("addingSuccess") String successMessage,@ModelAttribute ("errorAdding") String errorMessage) {
		ModelAndView mv = new ModelAndView();
		List<Product> products = fetchDetailService.fetchAllProductDetails();
		System.out.println(products.size());
		if (products != null) { 
			mv.addObject("productList", products);			
			mv.addObject("name", name);
			if(successMessage.equals("1")) {mv.addObject("addingSuccess","ITEM ADDED SUCCESSFULLY");}
			if(errorMessage.equals("0")) {mv.addObject("errorAdding","ITEM CANNOT BE ADDED");}
			mv.setViewName("productPage");
			return mv;
		} else {
			mv.addObject("noProduct", "Sorry there is no available product to display");
			mv.setViewName("productPage");
			return mv;
		}
	}
	
	@RequestMapping(value="/fetchOrder")
	public ModelAndView fetchOrderDetails(@ModelAttribute("userId") int userId, HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		User user= fetchDetailService.fetchOrders(userId);
		if(user!=null)
		{
			List<Order> orders=user.getOrder();
			
	
			mv.addObject("orderList", orders);
			mv.addObject("name", user.getName());
			mv.setViewName("order");
			return mv;
		}
		mv.addObject("errorOrder", "We haven't  ordered anything yet!!!");
		return mv;
		
	}
	
	@RequestMapping(value="fetchAllUsers")
	public ModelAndView fetchAllUsers()
	{
		ModelAndView mv=  new ModelAndView();
		List<User> users=fetchDetailService.fetchAllUsers();
		if(users!=null)
		{
			mv.addObject("userList",users);
			mv.setViewName("users");
			return mv;
		}
		mv.addObject("noUser", "No users are there !!!");
		mv.setViewName("users");
		return mv;
		
	}
}
