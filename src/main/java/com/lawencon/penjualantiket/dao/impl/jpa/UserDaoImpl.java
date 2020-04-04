package com.lawencon.penjualantiket.dao.impl.jpa;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.UserDao;
import com.lawencon.penjualantiket.model.Customer;

@Repository("user_dao_jpa")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Customer validUser(String user, String pass) throws Exception {
		return userRepo.findByUsername(user, pass);
	}

	@Override
	public void insertUser(Customer customer) throws Exception {
		userRepo.save(customer);	
	}

	@Override
	public void editUser(Customer customer) throws Exception {
		userRepo.save(customer);		
	}

	@Override
	public void deleteUser(Customer customer) throws Exception {
		userRepo.deleteByUsername(customer.getUsername());
	}

	@Override
	public List<Customer> viewCustomer() throws Exception {
		return userRepo.findAll();
	}

	@Override
	public Customer findById(int id) throws Exception {
		return userRepo.findById(id).orElse(null);
	}

}
