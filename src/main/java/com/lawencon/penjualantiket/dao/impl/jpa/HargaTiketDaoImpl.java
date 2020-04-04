package com.lawencon.penjualantiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.HargaTiketDao;
import com.lawencon.penjualantiket.model.HargaTiket;

@Repository("harga_dao_jpa")
public class HargaTiketDaoImpl implements HargaTiketDao {

	@Autowired
	private HargaTiketRepo h_repo;

	@Override
	public void insertHarga(HargaTiket hTiket) throws Exception {
		h_repo.save(hTiket);
	}

	@Override
	public void editHarga(HargaTiket hTiket) throws Exception {
		h_repo.save(hTiket);
		
	}

	@Override
	public void deleteHarga(HargaTiket hTiket) throws Exception {
		h_repo.delete(hTiket);
	}

	@Override
	public List<HargaTiket> viewHargaTiket() throws Exception {
		return h_repo.findAll();
	}

	@Override
	public HargaTiket findById(int id) throws Exception {
		return h_repo.findById(id).orElse(null);
	}

}
