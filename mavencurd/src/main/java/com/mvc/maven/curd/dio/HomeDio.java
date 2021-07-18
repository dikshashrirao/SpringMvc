package com.mvc.maven.curd.dio;

import java.util.List;

import com.mvc.maven.curd.model.User;

public interface HomeDio {

	public int saveData(User user);

	public List<User> showAll();

	public List<User> showOne(String uname, String password);

	public void deleteRecord(int uid);

	public User editRecord(int uid);

	public List<User> updateRecord(User user);

}
