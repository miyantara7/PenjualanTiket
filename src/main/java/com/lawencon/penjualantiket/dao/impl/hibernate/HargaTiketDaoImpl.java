package com.lawencon.penjualantiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.HargaTiketDao;
import com.lawencon.penjualantiket.model.HargaTiket;

@Repository("harga_dao_hiber")
public class HargaTiketDaoImpl extends BaseHibernate implements HargaTiketDao{

	@Override
	public void insertHarga(HargaTiket hTiket) throws Exception {
		em.persist(hTiket);
	}

	@Override
	public void editHarga(HargaTiket hTiket) throws Exception {
		em.merge(hTiket);
		
	}

	@Override
	public void deleteHarga(HargaTiket hTiket) throws Exception {
		em.remove(hTiket);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<HargaTiket> viewHargaTiket() throws Exception {
		Query q = em.createQuery("from HargaTiket");
		return q.getResultList();
	}

	@Override
	public HargaTiket findById(int id) throws Exception {
		Query q = em.createQuery("from HargaTiket where hargaId =: idParam")
				.setParameter("idParam", id);
		return (HargaTiket) q.getSingleResult();
	}

}
