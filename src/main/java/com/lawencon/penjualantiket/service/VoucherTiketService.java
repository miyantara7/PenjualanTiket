package com.lawencon.penjualantiket.service;

import java.util.List;
import com.lawencon.penjualantiket.model.VoucherTiket;

public interface VoucherTiketService {
	abstract String insertVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass) throws Exception;
	abstract String editVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass, int id) throws Exception;
	abstract String deleteVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass) throws Exception;
	abstract List<VoucherTiket> viewVoucherTiketHiber(String user, String pass) throws Exception;
	
	abstract String insertVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass) throws Exception;
	abstract String editVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass, int id) throws Exception;
	abstract String deleteVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass) throws Exception;
	abstract List<VoucherTiket> viewVoucherTiketJpa(String user, String pass) throws Exception;
}
