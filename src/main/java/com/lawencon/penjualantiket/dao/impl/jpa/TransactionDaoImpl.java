package com.lawencon.penjualantiket.dao.impl.jpa;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.penjualantiket.dao.TransactionDao;
import com.lawencon.penjualantiket.model.Customer;
import com.lawencon.penjualantiket.model.HargaTiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.TransactionHeader;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository("transaction_repo_jpa")
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private TransactionHeaderRepo th_repo;

	@Autowired
	private TransactionDetailRepo td_repo;
	
	@Override
	public TransactionHeader findTransactionId() throws Exception {
		return th_repo.findByTransactionId();
	}

	@Override
	public int findMaxTransactionId() throws Exception {
		return th_repo.findByMaxTransactionId();
	}
	
	@Override
	public TransactionHeader insertHeader(TransactionHeader tHeader) throws Exception {
		return th_repo.save(tHeader);
	}

	@Override
	public List<TransactionDetail> viewAllTransactionId(int tId) throws Exception {
		return th_repo.findByIdtransaction(tId);
	}
	
	@Override
	public TransactionDetail insertTiket(TransactionDetail tDetail) throws Exception {
		return td_repo.save(tDetail);
	}

	@Override
	public Customer findByUsername(String user , String pass) throws Exception {
		return td_repo.findByUsername(user, pass);
	}

	@Override
	public HargaTiket findByHarga(int types) throws Exception {
		return td_repo.findByHarga(types);
	}

	@Override
	public VoucherTiket findByVoucher(String pocer) throws Exception {
		return td_repo.findByVoucher(pocer);
	}

	@Override
	public BigInteger findByTotal(int thId) throws Exception {
		return th_repo.findByTotalPembelian(thId);
	}





}
