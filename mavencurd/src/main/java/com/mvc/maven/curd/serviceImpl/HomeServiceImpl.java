package com.mvc.maven.curd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.maven.curd.dio.HomeDio;
import com.mvc.maven.curd.model.User;
import com.mvc.maven.curd.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeDio hd;
	
	public int saveData(User user) {
		return hd.saveData(user);
	}

	public List<User> showAll() {
		return hd.showAll();
	}

	public List<User> showOne(String uname, String password) {
		return hd.showOne(uname,password);
	}

	@Override
	public void deleteRecord(int uid) {
		hd.deleteRecord(uid);
	}

	@Override
	public User editRecord(int uid) {
		return hd.editRecord(uid);
	}

	@Override
	public List<User> updateRecord(User user) {
		return hd.updateRecord(user);
	}

}
