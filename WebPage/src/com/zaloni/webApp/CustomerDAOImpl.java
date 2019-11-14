package com.zaloni.webApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO
{

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertCustomer(Customer c)
	{
		int status=0;
		try {
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("insert into customer values (?,?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getUsername());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getPhone_num());
			ps.setString(5, c.getPassword());
			status=ps.executeUpdate();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Customer getCustomer(String username, String password) {
	
		Customer c= new Customer();
		try {
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from customer where username=? and password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c.setId(Integer.parseInt(rs.getString(1)));
				c.setName(rs.getString(2));
				c.setUsername(rs.getString(3));
				c.setAddress(rs.getString(4));
				c.setPhone_num(rs.getString(5));
				c.setPassword(rs.getString(6));
			}
			con.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	@Override
	public int updateCustomer(Customer c)
	{
		int status=0;
		try {
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("update customer set name=?,username=?,address=?,phone_num=?,password=? where id=?");
			ps.setString(1,c.getName());
			ps.setString(2,c.getUsername());
			ps.setString(3,c.getAddress());
			ps.setString(4,c.getPhone_num());
			ps.setString(5,c.getPassword());
			ps.setInt(6,c.getId());
			System.out.println(ps);
			status=ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	@Override
	public Customer searchCustomer(String name)
	{
		Customer c=new Customer();
		try {
			con=ConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from customer where id=? or name=?");
			ps.setString(1, name);
			ps.setString(2, name);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				c.setId(Integer.parseInt(rs.getString(1)));
				c.setName(rs.getString(2));
				c.setUsername(rs.getString(3));
				c.setAddress(rs.getString(4));
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		}

}
