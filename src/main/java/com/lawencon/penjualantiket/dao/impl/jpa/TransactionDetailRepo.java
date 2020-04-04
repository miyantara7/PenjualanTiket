package com.lawencon.penjualantiket.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.Customer;
import com.lawencon.penjualantiket.model.HargaTiket;
import com.lawencon.penjualantiket.model.TransactionDetail;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository
public interface TransactionDetailRepo extends JpaRepository<TransactionDetail, Integer> {

	@Query("from Customer where username = :userParam and password = :passParam")
	abstract Customer findByUsername(@Param("userParam")String user, @Param("passParam")String pass) throws Exception;
	
	@Query("from HargaTiket ht join ht.typeKendaraan tk where tk.typeId = :idParam")
	abstract HargaTiket findByHarga(@Param("idParam") int types) throws Exception;
	
	@Query("from VoucherTiket where kodeVoucher = :paramKode")
	abstract VoucherTiket findByVoucher(@Param("paramKode") String pocer) throws Exception;
}
