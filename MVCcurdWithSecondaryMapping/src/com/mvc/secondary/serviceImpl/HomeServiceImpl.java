package com.mvc.secondary.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.secondary.dio.HomeDio;
import com.mvc.secondary.model.User;
import com.mvc.secondary.service.HomeService;
 
  
@Service
public class HomeServiceImpl  implements HomeService{

	 @Autowired
	  HomeDio hd;
	 
	@Override
	public int saveData(User user) {
		return 	hd.saveData(user);
	}

	@Override
	public List<User> showAllRecords() {
		return hd.showAllRecords();
	}

	@Override
	public List<User> showOneRecord(String uname, String password) {
		return hd.showOneRecord(uname,password);	
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
	public void updateRecord(User user) {
	   hd.updateRecord(user);	
	}

	

	

}
