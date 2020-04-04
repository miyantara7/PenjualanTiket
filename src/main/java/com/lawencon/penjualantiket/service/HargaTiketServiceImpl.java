package com.lawencon.penjualantiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.dao.HargaTiketDao;
import com.lawencon.penjualantiket.model.HargaTiket;
import com.lawencon.penjualantiket.model.Type;

@Service
@Transactional
public class HargaTiketServiceImpl implements HargaTiketService {

	@Autowired
	@Qualifier("harga_dao_hiber")
	private HargaTiketDao hiber_dao;

	@Autowired
	@Qualifier("harga_dao_jpa")
	private HargaTiketDao jpa_dao;

	@Autowired
	private UserService userService;

	@Override
	public String insertHargaHiber(HargaTiket hTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			hiber_dao.insertHarga(hTiket);
			return "Berhasil insert data !";
		} else {
			return "Username atau password salah !";
		}

	}

	@Override
	public String editHargaHiber(HargaTiket hTiket, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			HargaTiket hTiket2 = null;
			Type typeKendaraan = new Type();
			try {
				hTiket2 = hiber_dao.findById(id);
			} catch (Exception e) {

			}
			if (hTiket2 != null) {
				hTiket2.setHarga(hTiket.getHarga());
				typeKendaraan.setTypeId(hTiket.getTypeKendaraan().getTypeId());
				hTiket2.setTypeKendaraan(typeKendaraan);
				hiber_dao.editHarga(hTiket2);
				return "Berhasil";
			} else {
				return "Id harga tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteHargaHiber(HargaTiket hTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			HargaTiket hTiket2 = null;
			try {
				hTiket2 = hiber_dao.findById(hTiket.getHargaId());
			} catch (Exception e) {

			}
			if (hTiket2 != null) {
				hiber_dao.deleteHarga(hTiket2);
				return "Delete harga tiket Berhasil";
			} else {
				return "Id harga tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<HargaTiket> viewHargaHiber(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return hiber_dao.viewHargaTiket();
		} else {
			return null;
		}
	}

	@Override
	public String insertHargaJpa(HargaTiket hTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			jpa_dao.insertHarga(hTiket);
			return "Berhasil insert data !";
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editHargaJpa(HargaTiket hTiket, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			HargaTiket hTiket2 = null;
			Type typeKendaraan = new Type();
			try {
				hTiket2 = jpa_dao.findById(id);
			} catch (Exception e) {

			}
			if (hTiket2 != null) {
				hTiket2.setHarga(hTiket.getHarga());
				typeKendaraan.setTypeId(hTiket.getTypeKendaraan().getTypeId());
				hTiket2.setTypeKendaraan(typeKendaraan);
				jpa_dao.editHarga(hTiket2);
				return "Berhasil";
			} else {
				return "Id harga tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteHargaJpa(HargaTiket hTiket, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			HargaTiket hTiket2 = null;
			try {
				hTiket2 = jpa_dao.findById(hTiket.getHargaId());
			} catch (Exception e) {

			}
			if (hTiket2 != null) {
				jpa_dao.deleteHarga(hTiket2);
				return "Delete harga tiket Berhasil";
			} else {
				return "Id harga tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<HargaTiket> viewHargaJpa(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return jpa_dao.viewHargaTiket();
		} else {
			return null;
		}
	}

}
