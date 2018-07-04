package com.demo.example.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.example.model.UserModel;
import com.demo.example.service.TestAppService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class DemoHelloWorld { 

	@Autowired
	TestAppService testAppService;
	

	
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public @ResponseBody ResponseEntity<Object> checkTestMapping(@RequestBody Object user,HttpServletRequest httpServletRequest,HttpServletResponse response){
		  String a = new String("testApp");
		  System.out.println("Context Path : " + httpServletRequest.getContextPath());
		  // Set response content type
	      response.setContentType("text/html");

	      // New location to be redirected
	      String site = new String("https://www.google.com");

	      response.setStatus(response.SC_MOVED_TEMPORARILY);
	      response.setHeader("Location", site);
		  ObjectMapper obj = new ObjectMapper();
		  UserModel userModel = obj.convertValue(user, UserModel.class);
		  testAppService.validateUserLogin((UserModel) userModel);
		  ResponseEntity<Object> response1 = null;
		  response1 = new ResponseEntity<Object>(user,HttpStatus.OK);
		  return response1;
	  }
	  
	  @RequestMapping(value = "/createUser", method = RequestMethod.POST)
	  public @ResponseBody ResponseEntity<Object> createUser(@RequestBody UserModel user){
		  System.out.println(user);
		  String a = new String("testApp");
		  testAppService.createUser((UserModel) user);
		  ResponseEntity<Object> response = null;
		  response = new ResponseEntity<Object>(user,HttpStatus.OK);
		  return response;
	  }
	  
	  @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	  public @ResponseBody ResponseEntity<Object> uploadFile(@ModelAttribute Object multipartFile){
		  System.out.println(multipartFile);
		  String a = new String("testApp");
		  ResponseEntity<Object> response = null;
		  response = new ResponseEntity<Object>(a,HttpStatus.NOT_FOUND);
		  return response;
	  }

	  
	  @RequestMapping(value="/test", method = RequestMethod.GET)
	  public String test (HttpServletRequest request, HttpServletResponse response) {
		  return "abcd";
	  }
	

@RequestMapping(value="/logout", method = RequestMethod.GET)
public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){    
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
}
}
















