package com.lawencon.penjualantiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.TypeDao;
import com.lawencon.penjualantiket.model.Type;

@Repository("type_dao_hiber")
public class TypeDaoImpl extends BaseHibernate implements TypeDao{

	@Override
	public void insertType(Type type) throws Exception {
		em.persist(type);
	}

	@Override
	public void editType(Type type) throws Exception {
		em.merge(type);
		
	}

	@Override
	public void deleteType(Type type) throws Exception {
		em.remove(type);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Type> viewType() throws Exception {
		Query q = em.createQuery("from Type");
		return q.getResultList();
	}

	@Override
	public Type findById(int id) throws Exception {
		Query q = em.createQuery("from Type where typeId =: idParam")
				.setParameter("idParam", id);
		return (Type) q.getSingleResult();
	}

	@Override
	public Type findType(Type type) throws Exception {
		Query q = em.createQuery("from Type where kodeType =: idParam")
				.setParameter("idParam", type.getKodeType());
		return (Type) q.getSingleResult();
	}



}
