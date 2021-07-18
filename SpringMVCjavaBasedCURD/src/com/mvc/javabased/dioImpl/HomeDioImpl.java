package com.mvc.javabased.dioImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.javabased.dio.HomeDio;
import com.mvc.javabased.model.User;
@Repository
public class HomeDioImpl implements HomeDio{
    @Autowired
	SessionFactory sf;
    
	@Override
	public int saveRecord(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		int id=(int) s.save(user);
		tx.commit();
		s.close(); 
		return id;
	}

	@Override
	public List<User> showAll(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		List<User>list=s.createQuery("from User",User.class).getResultList();
		return list;
	}

	@Override
	public List<User> showOne(String uname, String pass) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q= s.createQuery("from User where uname=:uname and pass=:pass");
		q.setParameter("uname", uname);
		q.setParameter("pass", pass);
		User user=q.getSingleResult();
		List<User>list=new ArrayList<User>();
		list.add(user);
		return list;
	}

	@Override
	public List<User> deleteRecord(int id) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User user=s.get(User.class, id);
		s.delete(user);
		List<User>list=s.createQuery("from User",User.class).getResultList();
		return list;
	}

	@Override
	public User editRecord(int id) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		User user=s.get(User.class, id);
		return user;
	}

	@Override
	public List<User> updateRecord(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.update(user);
		List<User>list=s.createQuery("from User",User.class).getResultList();
		return list;
	}

}
