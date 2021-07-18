package com.mvc.maven.curd.dioImple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.maven.curd.dio.HomeDio;
import com.mvc.maven.curd.model.User;

@Repository
public class HomeDioImpl implements HomeDio{
   @Autowired
   SessionFactory sf;
	public int saveData(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		int id=(Integer) s.save(user);
		tx.commit();
		s.close();
		return id;
	}
	public List<User> showAll() {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("from User");
		List<User>list=q.getResultList();
		return list;
	}
	public List<User> showOne(String uname, String password) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query<User>q=s.createQuery("from User where uname=:uname and password=:password");
		q.setParameter("uname",uname);
		q.setParameter("password", password);
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
		User user=s.get(User.class, uid);
		tx.commit();
		s.close();
		return user;
	}
	@Override
	public List<User> updateRecord(User user) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.update(user);
		Query<User>q=s.createQuery("from User");
		List<User>list=q.getResultList();
		tx.commit();
		s.close();
		return list;
	}

}
