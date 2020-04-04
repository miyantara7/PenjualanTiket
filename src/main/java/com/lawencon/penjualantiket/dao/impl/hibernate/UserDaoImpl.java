package com.lawencon.penjualantiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.UserDao;
import com.lawencon.penjualantiket.model.Customer;

@Repository("user_dao_hibernate")
public class UserDaoImpl extends BaseHibernate implements UserDao {

	@Override
	public Customer validUser(String user, String pass) throws Exception {
		Query q = em.createQuery("from Customer where username =: userParam and password =: passParam")
				.setParameter("userParam", user).setParameter("passParam", pass);

		return (Customer) q.getSingleResult();
	}

	@Override
	public void insertUser(Customer customer) throws Exception {
		em.persist(customer);
	}

	@Override
	public void editUser(Customer customer) throws Exception {
		em.merge(customer);	
	}

	@Override
	public void deleteUser(Customer customer) throws Exception {
		em.remove(customer);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> viewCustomer() throws Exception {
		Query q = em.createQuery("from Customer");
		return q.getResultList();
	}

	@Override
	public Customer findById(int id) throws Exception {
		Query q = em.createQuery("from Customer where customerId =: idParam")
				.setParameter("idParam", id);
		return (Customer) q.getSingleResult();
	}

}
