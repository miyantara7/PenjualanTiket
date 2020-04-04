package com.lawencon.penjualantiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_type", uniqueConstraints = { @UniqueConstraint(name = "u_type", columnNames = { "kodeType" }) })
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String kodeType;
	private String jenisKendaraan;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getKodeType() {
		return kodeType;
	}

	public void setKodeType(String kodeType) {
		this.kodeType = kodeType;
	}

	public String getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

}
