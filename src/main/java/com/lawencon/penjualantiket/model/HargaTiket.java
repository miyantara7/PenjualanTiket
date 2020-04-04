package com.lawencon.penjualantiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hargatiket")
public class HargaTiket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hargaId;
	
	@ManyToOne
	@JoinColumn(name = "typeId", nullable = false)
	private Type typeKendaraan;
	private int harga;

	public int getHargaId() {
		return hargaId;
	}

	public void setHargaId(int hargaId) {
		this.hargaId = hargaId;
	}

	public Type getTypeKendaraan() {
		return typeKendaraan;
	}

	public void setTypeKendaraan(Type typeKendaraan) {
		this.typeKendaraan = typeKendaraan;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

}
