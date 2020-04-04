package com.lawencon.penjualantiket.service;
import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.dao.TransactionDao;
import com.lawencon.penjualantiket.model.Tiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.TransactionHeader;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	@Qualifier("transaction_repo_jpa")
	private TransactionDao td_dao;

	@Autowired
	@Qualifier("transaction_repo_hiber")
	private TransactionDao th_dao;

	@Autowired
	private UserService userService;

	@Override
	public List<TransactionDetail> insertTiketJpa(String pocer, String user, String pass, List<Tiket> listTiket)
			throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			TransactionHeader tHeader = new TransactionHeader();
			TransactionHeader tHeader3 = null;
			tHeader.setCustomer(td_dao.findByUsername(user, pass));
			try {
				tHeader3 = td_dao.findTransactionId();
			} catch (Exception e) {
				
			}
			if (tHeader3 != null) {
				int id = td_dao.findMaxTransactionId();
				tHeader.setTransactionId(id + 1);
			} else {
				tHeader.setTransactionId(Integer.valueOf(1));
			}
			tHeader.setVoucherTiket(td_dao.findByVoucher(pocer));
			TransactionHeader tHeader2 = td_dao.insertHeader(tHeader);

			listTiket.stream().forEach(val -> {
				TransactionDetail tDetail = new TransactionDetail();
				tDetail.setNama(val.getNama());
				tDetail.setSeatNumber(val.getSeatNumber());
				tDetail.setTglKeberangakatan(val.getTglBerangkat());
				tDetail.setTransactionHeader(tHeader2);
				tDetail.setTypeKendaraan(val.getTypeKendaraan());
				try {
					tDetail.setHargaTiket(td_dao.findByHarga(val.getTypeKendaraan().getTypeId()));
					td_dao.insertTiket(tDetail);
					BigInteger total = td_dao.findByTotal(tDetail.getTransactionHeader().getHeaderId());
					BigInteger harga = BigInteger.valueOf(tHeader2.getVoucherTiket().getHarga());
					BigInteger totalSemua = total.subtract(harga);
					tHeader2.setTotalPembelian(totalSemua);
					td_dao.insertHeader(tHeader2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			return td_dao.viewAllTransactionId(tHeader2.getTransactionId());
		} else {
			return null;
		}
	}

	@Override
	public List<TransactionDetail> insertTiketHiber(String pocer, String user, String pass, List<Tiket> listtiket)
			throws Exception {
		if (userService.validUserHiber(user, pass) == true) {
			TransactionHeader tHeader = new TransactionHeader();
			TransactionHeader tHeader3 = null;
			tHeader.setCustomer(th_dao.findByUsername(user, pass));
			try {
				tHeader3 = th_dao.findTransactionId();
			} catch (Exception e) {
				
			}
			if (tHeader3 != null) {
				int id = th_dao.findMaxTransactionId();
				tHeader.setTransactionId(id + 1);
			} else {
				tHeader.setTransactionId(Integer.valueOf(1));
			}
			tHeader.setVoucherTiket(th_dao.findByVoucher(pocer));
			TransactionHeader tHeader2 = th_dao.insertHeader(tHeader);
			listtiket.stream().forEach(val -> {
				TransactionDetail tDetail = new TransactionDetail();
				tDetail.setNama(val.getNama());
				tDetail.setSeatNumber(val.getSeatNumber());
				tDetail.setTglKeberangakatan(val.getTglBerangkat());
				tDetail.setTransactionHeader(tHeader2);
				tDetail.setTypeKendaraan(val.getTypeKendaraan());
				try {
					tDetail.setHargaTiket(th_dao.findByHarga(val.getTypeKendaraan().getTypeId()));
					th_dao.insertTiket(tDetail);
					BigInteger total = th_dao.findByTotal(tDetail.getTransactionHeader().getHeaderId());
					BigInteger harga = BigInteger.valueOf(tHeader2.getVoucherTiket().getHarga());
					BigInteger totalSemua = total.subtract(harga);
					tHeader2.setTotalPembelian(totalSemua);
					th_dao.insertHeader(tHeader2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			return th_dao.viewAllTransactionId(tHeader2.getTransactionId());
		} else {
			return null;
		}
	}

}
