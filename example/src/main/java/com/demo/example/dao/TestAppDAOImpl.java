package com.demo.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.example.model.UserModel;
import com.demo.example.utils.PasswordUtils;

@Repository
public class TestAppDAOImpl implements TestAppDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FetchAllUSers = "select * from user";
    
    private static final String SQL_FIND_USER = "select * from user where username=?";


	@Override
	public void getAllUsers() {
		try {
	         //List<Customer> customers = new ArrayList<Customer>();
	         List<Map<String, Object>> rows = jdbcTemplate.queryForList(FetchAllUSers);

	         for (Map<String, Object> row : rows) 
	         {
	            /*  Customer customer = new Customer();
	              customer.setCustNo((int)row.get("Cust_id"));
	              customer.setCustName((String)row.get("Cust_name"));
	              customer.setCountry((String)row.get("Country"));*/
	              System.out.println((int)row.get("UserID"));
	             // customers.add(customer);
	          }

	       // return customers;
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	

	@Override
	public void createUser(UserModel userModel) {
		try {
		String insertSql="insert into user (userName,Email,Password,PassKey) values (?,?,?,?);";
		jdbcTemplate.update(insertSql,new Object[]{userModel.getUserName(),userModel.getEmail(),PasswordUtils.generateSecurePassword(userModel.getPassword(),userModel.getPassKey()),userModel.getPassKey()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel getUserByUserName(String username) {
		UserModel user = null;
		try {
	         //List<Customer> customers = new ArrayList<Customer>();
	        user = (UserModel) jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { username },new BeanPropertyRowMapper(UserModel.class));

	    

	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return user;
	}

}
