package com.lawencon.penjualantiket.dao.impl.jpa;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.TransactionHeader;

@Repository
public interface TransactionHeaderRepo extends JpaRepository<TransactionHeader, Integer> {

	@Query(value="SELECT * FROM tb_transaction_header ORDER BY header_id DESC LIMIT 1", nativeQuery = true)
	abstract TransactionHeader findByTransactionId() throws Exception;

	@Query(value = "Select max(transaction_id) from tb_transaction_header tth", nativeQuery = true)
	abstract int findByMaxTransactionId() throws Exception;

	@Query("from TransactionDetail td join td.transactionHeader th where th.transactionId = :paramId")
	abstract List<TransactionDetail> findByIdtransaction(@Param("paramId") int tId) throws Exception;

	@Query(value = "select sum(th.harga) from tb_hargatiket th join tb_transaction_detail td "
			+ "on th.harga_id = td.harga_id where td.header_id = ?1", nativeQuery = true)
	abstract BigInteger findByTotalPembelian(int thId) throws Exception;
}
