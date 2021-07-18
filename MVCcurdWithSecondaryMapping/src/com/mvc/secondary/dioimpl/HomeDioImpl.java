package com.mvc.secondary.dioimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.secondary.dio.HomeDio;
import com.mvc.secondary.model.User;

@Repository
public class HomeDioImpl implements HomeDio{
   @Autowired
	SessionFactory sf;
	
	@Override
	public int saveData(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		int id=(int) s.save(user);
		tx.commit();
		s.close();
		return id;
	}

	@Override
	public List<User> showAllRecords() {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("from User");
		List<User>list=q.getResultList();
		return list;
	}

	@Override
	public List<User> showOneRecord(String uname, String password) {
	Session s=sf.openSession();
	Transaction tx=s.beginTransaction();
	Query< User>q=s.createQuery("from User where uname=:un and password=:ps");
	q.setParameter("un", uname);
	q.setParameter("ps", password);
	List<User>list=q.getResultList();
		return list;
	}

	@Override
	public void deleteRecord(int uid) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("delete from User where uid=:uid");
		q.setParameter("uid", uid);
		q.executeUpdate();
		tx.commit();
		s.close();
	}

	@Override
	public User editRecord(int uid) {
	Session s=sf.openSession();
	Transaction tx=s.beginTransaction();
	Query<User>q=s.createQuery("from User where uid=:uid");
	q.setParameter("uid", uid);
	User user=q.getSingleResult();
	tx.commit();
	s.close();
	return user;
	}

	@Override
	public void updateRecord(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
	      s.update(user);
		  tx.commit();
		  	s.close();
		  	
	}

}
