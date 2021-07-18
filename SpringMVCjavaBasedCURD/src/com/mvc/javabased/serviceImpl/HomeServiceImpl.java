package com.mvc.javabased.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.javabased.dio.HomeDio;
import com.mvc.javabased.model.User;
import com.mvc.javabased.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService{
    @Autowired
    HomeDio hd;
    
	@Override
	public int saveRecord(User user) {
		return hd.saveRecord(user);	
	}

	@Override
	public List<User> showAll(User user) {
		return hd.showAll(user);
	}

	@Override
	public List<User> showOne(String uname, String pass) {
		return hd.showOne(uname,pass);
	}

	@Override
	public List<User> deleteRecord(int id) {
		return hd.deleteRecord(id);
	}

	@Override
	public User editRecord(int id) {
		return hd.editRecord(id);
	}

	@Override
	public List<User> updateRecord(User user) {
		return hd.updateRecord(user);
	}

}
