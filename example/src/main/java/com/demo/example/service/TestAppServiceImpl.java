package com.demo.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dao.TestAppDAO;
import com.demo.example.model.UserModel;
import com.demo.example.utils.PasswordUtils;

@Service
public class TestAppServiceImpl implements TestAppService {

	@Autowired
	TestAppDAO testAppDAO;
	
	@Override
	public void validateUserLogin(UserModel user) {
		System.out.println("Entered TestAppService");
		//testAppDAO.getAllUsers();
		UserModel userFromDB = testAppDAO.getUserByUserName(user.getUserName());
		
		System.out.println(user.getPassword());
		System.out.println(userFromDB.getPassword());
		if(PasswordUtils.verifyUserPassword(user.getPassword(), userFromDB.getPassword(),userFromDB.getPassKey())) {
			System.out.println("Authenticated.");
		}else {
			System.out.println("Wrong Password");
		}
				
		
	}

	@Override
	public void createUser(UserModel userModel) {
		System.out.println("Entered TestAppService");
		testAppDAO.createUser(userModel);
		
	}

}
