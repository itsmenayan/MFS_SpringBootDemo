package com.demo.example.dao;

import com.demo.example.model.UserModel;

public interface TestAppDAO {
	
	public void getAllUsers();
	
	public UserModel getUserByUserName(String username);

	public void createUser(UserModel userModel);

}
