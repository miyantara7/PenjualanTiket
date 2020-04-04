package com.lawencon.penjualantiket.service;

import java.util.List;

import com.lawencon.penjualantiket.model.Tiket;
import com.lawencon.penjualantiket.model.TransactionDetail;

public interface TransactionService {

	abstract List<TransactionDetail> insertTiketJpa(String pocer, String user, String pass, List<Tiket> tiket) throws Exception;
	abstract List<TransactionDetail> insertTiketHiber(String pocer, String user, String pass, List<Tiket> tiket) throws Exception;
}
