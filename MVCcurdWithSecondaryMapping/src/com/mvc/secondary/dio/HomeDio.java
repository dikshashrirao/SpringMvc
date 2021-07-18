package com.mvc.secondary.dio;

import java.util.List;

import com.mvc.secondary.model.User;

public interface HomeDio {

	public int saveData(User user);

	public List<User> showAllRecords();

	public List<User> showOneRecord(String uname,String password);

	public void deleteRecord(int uid);

	public User editRecord(int uid);

	public void updateRecord(User user);
}
