package com.lawencon.penjualantiket.dao;
import java.math.BigInteger;
import java.util.List;

import com.lawencon.penjualantiket.model.Customer;
import com.lawencon.penjualantiket.model.HargaTiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.TransactionHeader;
import com.lawencon.penjualantiket.model.VoucherTiket;

public interface TransactionDao {

	abstract TransactionHeader findTransactionId() throws Exception;
	abstract int findMaxTransactionId() throws Exception;
	abstract TransactionHeader insertHeader(TransactionHeader tHeader) throws Exception;
	abstract TransactionDetail insertTiket(TransactionDetail tDetail) throws Exception;
	abstract List<TransactionDetail> viewAllTransactionId(int tId) throws Exception;
	abstract Customer findByUsername(String user , String pass) throws Exception;
	abstract HargaTiket findByHarga(int types) throws Exception;
	abstract VoucherTiket findByVoucher(String pocer) throws Exception;
	abstract BigInteger findByTotal(int thId) throws Exception;
}
