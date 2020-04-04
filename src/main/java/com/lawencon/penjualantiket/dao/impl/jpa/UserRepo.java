package com.lawencon.penjualantiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.Customer;
@Repository
public interface UserRepo extends JpaRepository<Customer, Integer>{
	
	@Query(value ="select *from tb_customer u where u.username = ?1 and u.password = ?2",  nativeQuery = true)
	abstract Customer findByUsername(String user, String pass) throws Exception;
	abstract void deleteByUsername(String username) throws Exception;
}
