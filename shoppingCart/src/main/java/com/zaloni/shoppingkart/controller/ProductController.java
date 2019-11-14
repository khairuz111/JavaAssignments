package com.zaloni.shoppingkart.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Order;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;
import com.zaloni.shoppingkart.service.IFetchDetailService;

@Controller
@SessionAttributes({"name","userId"})
public class ProductController {

	@Autowired
	private IFetchDetailService fetchDetailService;
	
	@RequestMapping(value="/buyProduct", method= RequestMethod.POST)
	public ModelAndView buyProduct(@ModelAttribute("userId") int userId,@ModelAttribute("username") String name,HttpServletRequest req)
	{
		ModelAndView mv= new ModelAndView(); 
		int pId=Integer.parseInt(req.getParameter("pId"));
		boolean result;
		result=fetchDetailService.addToCart(pId, userId);
		
		if(result)
		{
			
			return new ModelAndView("redirect:/cartDetails");
		}
		else
		{
			mv.addObject("errorMessage","Sorry Item unvailable");
			mv.setViewName("productPage");
			return mv;
		}
	}
	

	@RequestMapping(value="addToCart", method= RequestMethod.POST)
	public String addProductToCart(@ModelAttribute ("userId") int userId,HttpServletRequest req, RedirectAttributes ra)
	{
		System.out.println("Inside addToCart, userId "+userId);
		int pId=Integer.parseInt(req.getParameter("pId"));
		
		boolean result;
		result=fetchDetailService.addToCart(pId, userId);
		if(result)
		{
			ra.addFlashAttribute("addingSuccess", "1");
			return "redirect:/allProducts";
		}
		else 
		{
			ra.addFlashAttribute("errorAdding", "0");
			return "redirect:/allProducts";
		}
		
	}
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("name") String name,Model model,HttpServletRequest request, RedirectAttributes ra)
	{
		Product product= new Product();
		product.setpName(request.getParameter("productName"));
		product.setpCategory(request.getParameter("productCategory"));
		product.setpPrice(Integer.parseInt(request.getParameter("productPrice")));
		boolean result=fetchDetailService.addProduct(product);
		if(result)
		{
			ra.addFlashAttribute("productAdded", "1");
			return "redirect:/adminHome";
		}
		else
		{
			model.addAttribute("addindFailed", "Product was not added,Kindly retry");
			return "addProduct";
		}
	}
	
	@RequestMapping(value="deleteFromCart", method = RequestMethod.POST)
	public String deleteFromCart(@ModelAttribute ("userId") int userId,HttpServletRequest req,RedirectAttributes ra)
	{
		int cartId=Integer.parseInt(req.getParameter("cartId"));
		boolean result;
		Cart cart=fetchDetailService.fetchCartDetailsbyCartId(cartId);
		if(cart!=null)
		{
			result=fetchDetailService.deleteCart(cart);
			if(result)
			{
				ra.addFlashAttribute("deleteSuccess", "1");
				return "redirect:/cartDetails";
			}
			else
			{
				ra.addFlashAttribute("deleteError", "0");
				return "redirect:/cartDetails";
			}
		}
		ra.addFlashAttribute("deleteError", "0");
		return "redirect:/cartDetails";
	}
	
	@RequestMapping(value="/deleteProduct", method= RequestMethod.POST)
	public String deleteProduct(HttpServletRequest req,RedirectAttributes ra)
	{
		int productId =Integer.parseInt(req.getParameter("pId"));
		
		Product  product=fetchDetailService.fetchProductDetailsById(productId);
		List<User> users=fetchDetailService.fetchAllUsers();
		boolean result;
		if(users!=null)
		{
			for(User e:users)
			{
				List<Cart> carts=e.getCart();
				for(Cart c: carts)
				{
					if(c.getProduct().getpId()==productId)
					{
						result=fetchDetailService.deleteCart(c);
						if(result)
						{
							result=fetchDetailService.deleteProduct(product);
							if(result)
							{
								ra.addFlashAttribute("deleteSuccess", "1");
								return "redirect:/adminHome";
							}
							else
							{
								ra.addFlashAttribute("deleteError", "0");
								return "redirect:/adminHome";
							}
						}
						ra.addFlashAttribute("deleteError", "0");
						return "redirect:/adminHome";
					}
				}
			}
		}
		result=fetchDetailService.deleteProduct(product);
		if(result)
		{
			ra.addFlashAttribute("deleteSuccess", "1");
			return "redirect:/adminHome";
		}
		else
		{
			ra.addFlashAttribute("deleteError", "0");
			return "redirect:/adminHome";
		}
		
	}
	
	@RequestMapping(value="/order", method= RequestMethod.POST)
	public ModelAndView order(@ModelAttribute ("userId") int userId,HttpServletRequest req)
	{
		ModelAndView mv=new  ModelAndView();
		User user= fetchDetailService.fetchUserDetails(userId);
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String currentDate = formatter.format(date);  
	    int sum=0;
	    boolean flag = false;
	    Random rand= new Random();
		if(user!=null) 
		{
			List<Product> products=new ArrayList<Product>();
			List<Cart>  carts=user.getCart();
			for(Cart c:carts)
			{
				products.add(c.getProduct());
			}
			if(products!=null)
			{
				for(Product p: products)
				{
					Order order=new Order();
					order.setOrderId(rand.nextInt(100000));
					order.setDate(currentDate);
					order.setProduct(p);
					order.setUser(user);
					sum=sum+p.getpPrice();
					flag=fetchDetailService.order(order);
				}
				if(flag)
				{
					for(Cart c:carts)
					{
						flag=fetchDetailService.deleteCart(c);
					}
					if(flag)
					{
						mv.addObject("orderSuccess", "Your Order was successfully placed, You will get your product delivered by 5 to 10 working days");
						mv.addObject("address", user.getAddress());
						mv.addObject("amount", sum);
						mv.addObject("name", user.getName());
						mv.setViewName("payment");
						return mv;
					}
					mv.addObject("orderError","Your order was not placed Successfully");
					mv.setViewName("payment");
					return mv;
				}
			}
		}
		mv.addObject("orderError", "Your order was not placed Successfully");
		return mv;
		
	}
}
