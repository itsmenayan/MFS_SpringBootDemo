package com.demo.example.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan({ "com.demo.example.controller" })
public class WebMvcConfig {
  @Configuration
  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
//	      http.authorizeRequests()
//	      .antMatchers("/css/**","/fonts/**","/images/**","/js/**","/vendor/**","/views/**","/app.js","/TestApp/","*/**").permitAll()
//	          .antMatchers("/**")//allow all urls
//	          .authenticated()//all URLs are allowed by any authenticated user, no role restrictions.
//	          .and()
//	          .formLogin()//enable form based authentication
	          //.loginPage("/index.html")//use a custom login URI
	          //.defaultSuccessUrl("/indexPLATO.html")
//	          .permitAll(true)//login URI can be accessed by anyone
//	          .and()
//	          .logout()//default logout handling
//	          .logoutSuccessUrl("/my-login?logout")//our new logout success url, we are not replacing other defaults.
//	          .permitAll();//allow all as it will be accessed when user is not logged in anymore

	 
	  http.authorizeRequests()
      .antMatchers("/login").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin().permitAll();
	  }

	  

  
  }
}