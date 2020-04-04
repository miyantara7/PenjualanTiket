package com.lawencon.penjualantiket.dao;

import java.util.List;

import com.lawencon.penjualantiket.model.Customer;

public interface UserDao {
	abstract Customer validUser(String user, String pass) throws Exception;
	abstract void insertUser(Customer customer) throws Exception;
	abstract void editUser(Customer customer) throws Exception;
	abstract void deleteUser(Customer customer) throws Exception;
	abstract List<Customer> viewCustomer() throws Exception;
	abstract Customer findById(int id) throws Exception;
}
