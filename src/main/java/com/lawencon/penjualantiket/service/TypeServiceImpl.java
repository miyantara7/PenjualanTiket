package com.lawencon.penjualantiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.penjualantiket.dao.TypeDao;
import com.lawencon.penjualantiket.model.Type;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	@Qualifier("type_dao_hiber")
	private TypeDao h_dao;

	@Autowired
	@Qualifier("type_dao_jpa")
	private TypeDao jpa_dao;

	@Autowired
	private UserService userService;

	@Override
	public String insertTypeHiber(Type type, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type type2 = null;
			try {
				type2 = h_dao.findType(type);			
			} catch (Exception e) {
				
			}
			
			if (type2 != null) {
				return "Kode type sudah tersedia !";
			} else {
				h_dao.insertType(type);
				return "Berhasil insert data !";
				
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editTypeHiber(Type type, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type typeKendaraan2 = null;
			try {
				typeKendaraan2 = h_dao.findById(id);
			} catch (Exception e) {

			}
			if (typeKendaraan2 != null) {
				typeKendaraan2.setJenisKendaraan(type.getJenisKendaraan());
				typeKendaraan2.setKodeType(type.getKodeType());
				h_dao.editType(typeKendaraan2);
				return "Berhasil";
			} else {
				return "Id type tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteTypeHiber(Type type, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type typeKendaraan2 = null;
			try {
				typeKendaraan2 = h_dao.findById(type.getTypeId());
			} catch (Exception e) {

			}
			if (typeKendaraan2 != null) {
				h_dao.deleteType(typeKendaraan2);
				return "Delete type Berhasil";
			} else {
				return "Id type tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<Type> viewTypeHiber(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return h_dao.viewType();
		} else {
			return null;
		}
	}

	@Override
	public String insertTypeJpa(Type type, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type type2 = null;
			try {
				type2 = jpa_dao.findType(type);
			} catch (Exception e) {
			}
			if (type2 == null) {
				jpa_dao.insertType(type);
				return "Berhasil insert data !";
			} else {
				return "Kode type sudah tersedia !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String editTypeJpa(Type type, String user, String pass, int id) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type typeKendaraan2 = null;
			try {
				typeKendaraan2 = jpa_dao.findById(id);
			} catch (Exception e) {

			}
			if (typeKendaraan2 != null) {
				typeKendaraan2.setJenisKendaraan(type.getJenisKendaraan());
				typeKendaraan2.setKodeType(type.getKodeType());
				jpa_dao.editType(typeKendaraan2);
				return "Berhasil";
			} else {
				return "Id type tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public String deleteTypeJpa(Type type, String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			Type typeKendaraan2 = null;
			try {
				typeKendaraan2 = jpa_dao.findById(type.getTypeId());
			} catch (Exception e) {

			}
			if (typeKendaraan2 != null) {
				jpa_dao.deleteType(typeKendaraan2);
				return "Delete type Berhasil";
			} else {
				return "Id type tidak ada !";
			}
		} else {
			return "Username atau password salah !";
		}
	}

	@Override
	public List<Type> viewTypeJpa(String user, String pass) throws Exception {
		if (userService.validUserJpa(user, pass) == true) {
			return jpa_dao.viewType();
		} else {
			return null;
		}
	}

}
