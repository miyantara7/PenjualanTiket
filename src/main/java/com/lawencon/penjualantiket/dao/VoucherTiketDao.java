package com.lawencon.penjualantiket.dao;

import java.util.List;
import com.lawencon.penjualantiket.model.VoucherTiket;

public interface VoucherTiketDao {

	abstract void insertVoucher(VoucherTiket voucherTiket) throws Exception;
	abstract void editVoucher(VoucherTiket voucherTiket) throws Exception;
	abstract void deleteVoucher(VoucherTiket voucherTiket) throws Exception;
	abstract List<VoucherTiket> viewHargaTiket() throws Exception;
	abstract VoucherTiket findById(int id) throws Exception;
	abstract VoucherTiket cekVoucher(VoucherTiket voucherTiket) throws Exception;
	
}
