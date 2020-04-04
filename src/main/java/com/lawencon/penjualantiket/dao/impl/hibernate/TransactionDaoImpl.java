package com.lawencon.penjualantiket.dao.impl.hibernate;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.dao.TransactionDao;
import com.lawencon.penjualantiket.model.Customer;
import com.lawencon.penjualantiket.model.HargaTiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.TransactionHeader;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository("transaction_repo_hiber")
public class TransactionDaoImpl extends BaseHibernate implements TransactionDao {

	@Override
	public TransactionHeader findTransactionId() throws Exception {
		Query q = em.createQuery("from TransactionHeader").setMaxResults(1);
		return (TransactionHeader) q.getSingleResult();
	}

	@Override
	public int findMaxTransactionId() throws Exception {
		Query q = em.createQuery("Select max(transactionId) from TransactionHeader");
		return (int) q.getSingleResult();
	}

	@Override
	public TransactionHeader insertHeader(TransactionHeader tHeader) throws Exception {
		em.persist(tHeader);
		return tHeader;
	}

	@Override
	public TransactionDetail insertTiket(TransactionDetail tDetail) throws Exception {
		em.persist(tDetail);
		return tDetail;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TransactionDetail> viewAllTransactionId(int tId) throws Exception {
		Query q = em.createQuery(
				"select th.transactionId as id, td.nama, td.seatNumber, td.tglKeberangakatan, tk.jenisKendaraan, tht.harga, th.totalPembelian, tv.harga from TransactionDetail td join td.transactionHeader th join td.typeKendaraan tk join td.hargaTiket tht join th.voucherTiket tv where td.transactionHeader.transactionId =: idParam")
				.setParameter("idParam", tId);
		return q.getResultList();
	}

	@Override
	public Customer findByUsername(String user, String pass) throws Exception {
		Query q = em.createQuery("from Customer where username =: userParam and password =: passParam")
				.setParameter("userParam", user).setParameter("passParam", pass);
		return (Customer) q.getSingleResult();
	}

	@Override
	public HargaTiket findByHarga(int types) throws Exception {
		Query q = em.createQuery("from HargaTiket ht where ht.typeKendaraan.typeId = :idParam").setParameter("idParam",
				types);
		return (HargaTiket) q.getSingleResult();
	}

	@Override
	public VoucherTiket findByVoucher(String pocer) throws Exception {
		Query q = em.createQuery("from VoucherTiket where kodeVoucher =: paramKode").setParameter("paramKode", pocer);
		return (VoucherTiket) q.getSingleResult();
	}

	@Override
	public BigInteger findByTotal(int thId) throws Exception {
		Query q = em
				.createNativeQuery("select sum(th.harga) from tb_hargatiket th join "
						+ "tb_transaction_detail td on th.harga_id = td.harga_id where td.header_id = ?")
				.setParameter(1, thId);
		return (BigInteger) q.getSingleResult();
	}

}
