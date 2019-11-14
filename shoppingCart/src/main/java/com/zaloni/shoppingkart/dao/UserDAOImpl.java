package com.zaloni.shoppingkart.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zaloni.shoppingkart.entities.Cart;
import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;


@Repository
@Transactional
public class UserDAOImpl implements IUserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;

	public void AddUser() {
		// TODO Auto-generated method stub
		
	}

	public void DeleteUser() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public User fetchUserDetails(String username,String password) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username",username));
		criteria.add(Restrictions.eq("password",password));
		User user=(User) criteria.uniqueResult();
		

		if(user!=null)
		{ 
			return user;
		}
		return null;
	}

	public User fetchUserDeatils(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId",id));
		User user=(User) criteria.uniqueResult();
		if(user!=null)
		{ 
			Hibernate.initialize(user.getCart());
			return user;
		}
		return null;
	}

	
	public boolean regsiterUser(User user) {
		template.save(user);
		
		return true;
	}

	public List<User> fetchAllUsers() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		List<User> users=(List<User>) criteria.list();
		if (users!=null) 
		{
			for(User e: users)
				Hibernate.initialize(e.getCart());
				return users;
		}
		return null;
	}

	public User fetchUserOrderDetail(int userId) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId",userId));
		User user=(User) criteria.uniqueResult();
		if(user!=null)
		{ 
			Hibernate.initialize(user.getOrder());
			return user;
		}
		return null;
	}


	
	

}
