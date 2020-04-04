package com.lawencon.penjualantiket.service;

import java.util.List;

import com.lawencon.penjualantiket.model.Customer;

public interface UserService {
	
	abstract Boolean validUserHiber(String user, String pass) throws Exception;
	abstract Boolean validUserJpa(String user, String pass) throws Exception;
	abstract String insertUserHiber(Customer customer, String user, String pass) throws Exception;
	abstract String editUserHiber(Customer customer, String user, String pass, String user2) throws Exception;
	abstract String deleteUserHiber(Customer customer, String user, String pass) throws Exception;
	abstract List<Customer> viewUserHiber(String user, String pass) throws Exception;
	
	abstract String insertUserJpa(Customer customer, String user, String pass) throws Exception;
	abstract String editUserJpa(Customer customer, String user, String pass, String user2) throws Exception;
	abstract String deleteUserJpa(Customer customer, String user, String pass) throws Exception;
	abstract List<Customer> viewUserJpa(String user, String pass) throws Exception;
}
