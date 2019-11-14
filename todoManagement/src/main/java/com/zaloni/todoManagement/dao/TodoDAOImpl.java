package com.zaloni.todoManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zaloni.todoManagement.entities.Todos;
import com.zaloni.todoManagement.entities.User;

@Repository
@Transactional
public class TodoDAOImpl implements ITodoDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	public List<Todos> fetchTodos(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Todos.class);
		criteria.add(Restrictions.eq("id",id));
		List<Todos> todos=criteria.list();
		
		if(todos!=null)
		{
			return todos;
		}
		return null;
		
	}

	public boolean addTodoTask(Todos todo) {
		template.save(todo);
		return  true;
	}

	public Todos fetchTodosbyId(int id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Todos.class);
		criteria.add(Restrictions.eq("todoId",id));
		Todos todos=(Todos) criteria.uniqueResult();
		if(todos!=null)
			return todos;
		return null;
	}

	public boolean updateTodoTask(Todos todo) {
		template.saveOrUpdate(todo);
		return true;
	}

	public boolean deleteTodo(Todos todo) {
		template.delete(todo);
		return true;
	}

}
