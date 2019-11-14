package com.zaloni.todoManagement.dao;



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

import com.zaloni.todoManagement.entities.User;


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

	public boolean regsiterUser(User user) {
		template.save(user);
		
		return true;
	}

	public User fetchUserbyId(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId",id));
		User user=(User) criteria.uniqueResult();
		if(user!=null)
		{ 
			return user;
		}
		return null;
	}

	public User fetchUserAllDetails(int userId) {
		
		Session session = sessionFactory.getCurrentSession();  
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId",userId));
		User user=(User) criteria.uniqueResult();
		
		Hibernate.initialize(user.getTodos());
		return user;
	}


	
	

}
