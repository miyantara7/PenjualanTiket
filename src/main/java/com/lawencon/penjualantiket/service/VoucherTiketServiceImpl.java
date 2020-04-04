package com.lawencon.penjualantiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.dao.VoucherTiketDao;
import com.lawencon.penjualantiket.model.VoucherTiket;

@Service
@Transactional
public class VoucherTiketServiceImpl implements VoucherTiketService {

	@Autowired
	@Qualifier("voucher_dao_hiber")
	private VoucherTiketDao hiber_dao;

	@Autowired
	@Qualifier("voucher_dao_jpa")
	private VoucherTiketDao jpa_dao;

	@Autowired
	private UserService userService;

	@Override
	public String insertVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = hiber_dao.cekVoucher(voucherTiket);
			} catch (Exception e) {
			}
			if (voucherTiket2 == null) {
				hiber_dao.insertVoucher(voucherTiket);
				return "Berhasil insert data !";
			} else {
				return "Voucher sudah tersedia !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = hiber_dao.findById(id);
			} catch (Exception e) {

			}
			if (voucherTiket2 != null) {
				voucherTiket2.setHarga(voucherTiket.getHarga());
				voucherTiket2.setKodeVoucher(voucherTiket.getKodeVoucher());
				hiber_dao.editVoucher(voucherTiket2);
				return "Berhasil";
			} else {
				return "Id voucher tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteVoucherTiketHiber(VoucherTiket voucherTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = hiber_dao.findById(voucherTiket.getVoucherId());
			} catch (Exception e) {

			}
			if (voucherTiket2 != null) {
				hiber_dao.deleteVoucher(voucherTiket2);
				return "Delete voucher tiket Berhasil";
			} else {
				return "Id voucher tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<VoucherTiket> viewVoucherTiketHiber(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return hiber_dao.viewHargaTiket();
		} else {
			return null;
		}
	}

	@Override
	public String insertVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = jpa_dao.cekVoucher(voucherTiket);
			} catch (Exception e) {
			}
			if (voucherTiket2 == null) {
				jpa_dao.insertVoucher(voucherTiket);
				return "Berhasil insert data !";
			} else {
				return "Voucher sudah tersedia !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = jpa_dao.findById(id);
			} catch (Exception e) {

			}
			if (voucherTiket2 != null) {
				voucherTiket2.setHarga(voucherTiket.getHarga());
				voucherTiket2.setKodeVoucher(voucherTiket.getKodeVoucher());
				jpa_dao.editVoucher(voucherTiket2);
				return "Berhasil";
			} else {
				return "Id voucher tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteVoucherTiketJpa(VoucherTiket voucherTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			VoucherTiket voucherTiket2 = null;
			try {
				voucherTiket2 = jpa_dao.findById(voucherTiket.getVoucherId());
			} catch (Exception e) {

			}
			if (voucherTiket2 != null) {
				jpa_dao.deleteVoucher(voucherTiket2);
				return "Delete voucher tiket Berhasil";
			} else {
				return "Id voucher tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<VoucherTiket> viewVoucherTiketJpa(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return jpa_dao.viewHargaTiket();
		} else {
			return null;
		}
	}

}
