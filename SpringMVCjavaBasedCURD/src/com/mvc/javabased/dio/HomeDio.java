package com.mvc.javabased.dio;

import java.util.List;

import com.mvc.javabased.model.User;

public interface HomeDio {

	public int saveRecord(User user);

	public List<User> showAll(User user);

	public List<User> showOne(String uname, String pass);

	public List<User> deleteRecord(int id);

	public User editRecord(int id);

	public List<User> updateRecord(User user);

}
