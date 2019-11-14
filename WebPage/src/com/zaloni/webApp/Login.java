package com.zaloni.webApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customer c;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		CustomerDAO cd=new CustomerDAOImpl();
		Customer c=new Customer();
		HttpSession session=request.getSession();
		
		switch(submitType)
		{
			case "login":
			{
				c=cd.getCustomer(username, password);
				if(c!=null && c.getName()!=null)
				{
					session.setAttribute("id", c.getId());
					session.setAttribute("name", c.getName());
					session.setAttribute("username", username);
					session.setAttribute("address", c.getAddress());
					session.setAttribute("phone_num", c.getPhone_num());
					session.setAttribute("password", password);
					
					System.out.println("inside login");
					request.setAttribute("message", "Welcome "+c.getName());
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("message","Invalid Credentials");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				break;
			}
			case "register":
			{
				c.setName(request.getParameter("name"));
				c.setUsername(request.getParameter("username"));
				c.setAddress(request.getParameter("address"));
				c.setPhone_num(request.getParameter("phone_num"));
				c.setPassword(request.getParameter("password"));
				cd.insertCustomer(c);
				request.setAttribute("successMessage","Registration  done");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			}
			case "update":
			{
				int status=0;
				System.out.println(request.getParameter("id"));
				System.out.println(c.getName());
				c.setId(Integer.parseInt(request.getParameter("id")));
				c.setName(request.getParameter("name"));
				c.setUsername(request.getParameter("username"));
				c.setAddress(request.getParameter("address"));
				c.setPhone_num(request.getParameter("phone_num"));
				c.setPassword(request.getParameter("password"));
				status=cd.updateCustomer(c);
				if(status==1)
				{
					
					
					session.setAttribute("id", c.getId());
					session.setAttribute("name", c.getName());
					session.setAttribute("username", c.getUsername());
					session.setAttribute("address", c.getAddress());
					session.setAttribute("phone_num", c.getPhone_num());
					session.setAttribute("password", password);
					request.setAttribute("updateMessage", "Details saved successfuly");
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("updateMessage", "Details not saved ");
					request.getRequestDispatcher("edit.jsp").forward(request, response);
				}
				break;
			}
			case "search":
			{
				String search=request.getParameter("search");
				Customer cus=new Customer();
				cus=cd.searchCustomer(search);
				if(cus!=null)
				{
					request.setAttribute("searchMessage", "Results Found");
					request.setAttribute("id", c.getId());
					request.setAttribute("name", c.getName());
					request.setAttribute("username", c.getUsername());
					request.setAttribute("address", c.getAddress());
					
					request.getRequestDispatcher("search.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("searchMessage", "Result not Found ");
					request.getRequestDispatcher("search.jsp").forward(request, response);
				}
				
				break;
			}
			default:
			{

				request.setAttribute("message","Invalid Credentials");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}

