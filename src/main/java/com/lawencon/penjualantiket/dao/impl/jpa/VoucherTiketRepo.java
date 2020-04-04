package com.lawencon.penjualantiket.dao.impl.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.penjualantiket.model.VoucherTiket;

@Repository
public interface VoucherTiketRepo extends JpaRepository<VoucherTiket, Integer> {

	@Query("from VoucherTiket where kodeVoucher = :kodeParam")
	abstract VoucherTiket findByKodeVoucher(@Param("kodeParam") String kode) throws Exception;
}
