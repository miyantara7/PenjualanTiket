package com.lawencon.penjualantiket.dao;

import java.util.List;
import com.lawencon.penjualantiket.model.HargaTiket;

public interface HargaTiketDao {

	abstract void insertHarga(HargaTiket hTiket) throws Exception;
	abstract void editHarga(HargaTiket hTiket) throws Exception;
	abstract void deleteHarga(HargaTiket hTiket) throws Exception;
	abstract List<HargaTiket> viewHargaTiket() throws Exception;
	abstract HargaTiket findById(int id) throws Exception;
}
