package com.lawencon.penjualantiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.TypeDao;
import com.lawencon.penjualantiket.model.Type;

@Repository("type_dao_jpa")
public class TypeDaoImpl implements TypeDao {

	@Autowired
	private TypeRepo t_repo;

	@Override
	public void insertType(Type type) throws Exception {
		t_repo.save(type);

	}

	@Override
	public void editType(Type type) throws Exception {
		t_repo.save(type);

	}

	@Override
	public void deleteType(Type type) throws Exception {
		t_repo.delete(type);

	}

	@Override
	public List<Type> viewType() throws Exception {
		return t_repo.findAll();
	}

	@Override
	public Type findById(int id) throws Exception {
		return t_repo.findById(id).orElse(null);
	}

	@Override
	public Type findType(Type type) throws Exception {
		return t_repo.findByKodeType(type.getKodeType());
	}

}
