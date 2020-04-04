package com.lawencon.penjualantiket.service;

import java.util.List;
import com.lawencon.penjualantiket.model.HargaTiket;

public interface HargaTiketService {

	abstract String insertHargaHiber(HargaTiket hTiket, String user, String pass) throws Exception;
	abstract String editHargaHiber(HargaTiket hTiket, String user, String pass, int id) throws Exception;
	abstract String deleteHargaHiber(HargaTiket hTiket, String user, String pass) throws Exception;
	abstract List<HargaTiket> viewHargaHiber(String user, String pass) throws Exception;
	
	abstract String insertHargaJpa(HargaTiket hTiket, String user, String pass) throws Exception;
	abstract String editHargaJpa(HargaTiket hTiket, String user, String pass, int id) throws Exception;
	abstract String deleteHargaJpa(HargaTiket hTiket, String user, String pass) throws Exception;
	abstract List<HargaTiket> viewHargaJpa(String user, String pass) throws Exception;
}
