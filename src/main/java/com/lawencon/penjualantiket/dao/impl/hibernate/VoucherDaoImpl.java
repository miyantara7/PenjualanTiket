package com.lawencon.penjualantiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.VoucherTiketDao;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository("voucher_dao_hiber")
public class VoucherDaoImpl extends BaseHibernate implements VoucherTiketDao{

	@Override
	public void insertVoucher(VoucherTiket voucherTiket) throws Exception {
		em.persist(voucherTiket);	
	}

	@Override
	public void editVoucher(VoucherTiket voucherTiket) throws Exception {
		em.merge(voucherTiket);
		
	}

	@Override
	public void deleteVoucher(VoucherTiket voucherTiket) throws Exception {
		em.remove(voucherTiket);	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VoucherTiket> viewHargaTiket() throws Exception {
		Query q = em.createQuery("from VoucherTiket");
		return q.getResultList();
	}

	@Override
	public VoucherTiket findById(int id) throws Exception {
		Query q = em.createQuery("from VoucherTiket where voucherId =: idParam")
				.setParameter("idParam", id);
		return (VoucherTiket) q.getSingleResult();
	}

	@Override
	public VoucherTiket cekVoucher(VoucherTiket voucherTiket) throws Exception {
		Query q = em.createQuery("from VoucherTiket where kodeVoucher =: idParam ")
				.setParameter("idParam", voucherTiket.getKodeVoucher());
		return (VoucherTiket) q.getSingleResult();
	}

}
