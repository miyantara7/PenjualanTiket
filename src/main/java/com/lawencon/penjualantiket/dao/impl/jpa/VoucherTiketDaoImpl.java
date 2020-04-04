package com.lawencon.penjualantiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.VoucherTiketDao;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository("voucher_dao_jpa")
public class VoucherTiketDaoImpl implements VoucherTiketDao {

	@Autowired
	private VoucherTiketRepo v_repo;

	@Override
	public void insertVoucher(VoucherTiket voucherTiket) throws Exception {
		v_repo.save(voucherTiket);

	}

	@Override
	public void editVoucher(VoucherTiket voucherTiket) throws Exception {
		v_repo.save(voucherTiket);

	}

	@Override
	public void deleteVoucher(VoucherTiket voucherTiket) throws Exception {
		v_repo.delete(voucherTiket);

	}

	@Override
	public List<VoucherTiket> viewHargaTiket() throws Exception {
		return v_repo.findAll();
	}

	@Override
	public VoucherTiket findById(int id) throws Exception {
		return v_repo.findById(id).orElse(null);
	}

	@Override
	public VoucherTiket cekVoucher(VoucherTiket voucherTiket) throws Exception {
		return v_repo.findByKodeVoucher(voucherTiket.getKodeVoucher());
	}

}
