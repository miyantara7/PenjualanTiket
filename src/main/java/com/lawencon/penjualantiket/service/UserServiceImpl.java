package com.lawencon.penjualantiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.dao.UserDao;
import com.lawencon.penjualantiket.model.Customer;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("user_dao_hibernate")
	private UserDao userDaoHiber;

	@Autowired
	@Qualifier("user_dao_jpa")
	private UserDao userDaoJpa;

	@Override
	public Boolean validUserHiber(String user, String pass) throws Exception {
		Customer users = null;
		try {
			users = userDaoHiber.validUser(user, pass);
		} catch (Exception e) {
		}

		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean validUserJpa(String user, String pass) throws Exception {
		Customer users = null;
		try {
			users = userDaoJpa.validUser(user, pass);
		} catch (Exception e) {
		}

		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String insertUserHiber(Customer customer, String user, String pass) throws Exception {
		if (validUserHiber(user, pass)) {
			Customer customer2 = null;
			try {
				customer2 = userDaoHiber.validUser(customer.getUsername(), customer.getPassword());
			} catch (Exception e) {
			}
			if (customer2 == null) {
				userDaoHiber.insertUser(customer);
				return "Berhasil insert data !";
			} else {
				return "Username sudah tersedia !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editUserHiber(Customer customer, String user, String pass, String user2) throws Exception {
		Customer cst = null;
		if (validUserHiber(user, pass)) {
			try {
				cst = userDaoHiber.validUser(user2, customer.getPassword());
			} catch (Exception e) {

			}
			if (cst != null) {
				cst.setNama(customer.getNama());
				cst.setPassword(customer.getPassword());
				userDaoHiber.editUser(cst);
				return "Berhasil";
			} else {
				return "User tidak ada";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteUserHiber(Customer customer, String user, String pass) throws Exception {
		if (validUserHiber(user, pass)) {
			Customer cst = null;
			try {
				cst = userDaoHiber.findById(customer.getCustomerId());
			} catch (Exception e) {
				
			}
			if (cst != null) {
				userDaoHiber.deleteUser(cst);
				return "Delete customer Berhasil !";
			} else {
				return "User tidak ada";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<Customer> viewUserHiber(String user, String pass) throws Exception {
		if (validUserHiber(user, pass)) {
			return userDaoHiber.viewCustomer();
		} else {
			return null;
		}
	}

	@Override
	public String insertUserJpa(Customer customer, String user, String pass) throws Exception {
		if (validUserJpa(user, pass)) {
			Customer customer2 = null;
			try {
				customer2 = userDaoJpa.validUser(customer.getUsername(), customer.getPassword());
			} catch (Exception e) {
			}
			if (customer2 == null) {
				userDaoJpa.insertUser(customer);
				return "Berhasil insert data !";
			} else {
				return "Username sudah tersedia !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editUserJpa(Customer customer, String user, String pass, String user2) throws Exception {
		if (validUserJpa(user, pass)) {
			Customer cst = null;
			try {
				cst = userDaoJpa.validUser(user2, customer.getPassword());
			} catch (Exception e) {

			}
			if (cst != null) {
				cst.setNama(customer.getNama());
				cst.setPassword(customer.getPassword());
				userDaoJpa.editUser(cst);
				return "Berhasil";
			} else {
				return "User tidak ada";
			}

		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteUserJpa(Customer customer, String user, String pass) throws Exception {
		if (validUserJpa(user, pass)) {
			Customer cst = null;
			try {
				cst = userDaoJpa.findById(customer.getCustomerId());
			} catch (Exception e) {

			}
			if (cst != null) {
				userDaoJpa.deleteUser(cst);
				return "Delete customer Berhasil";
			} else {
				return "User tidak ada";
			}

		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<Customer> viewUserJpa(String user, String pass) throws Exception {
		if (validUserJpa(user, pass)) {
			return userDaoJpa.viewCustomer();
		} else {
			return null;
		}
	}

}
