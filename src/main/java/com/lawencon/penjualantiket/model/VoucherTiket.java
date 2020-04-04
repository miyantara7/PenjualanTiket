package com.lawencon.penjualantiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_vouchertiket", uniqueConstraints = {
		@UniqueConstraint(name = "v_kode", columnNames = { "kodeVoucher" }) })
public class VoucherTiket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voucherId;
	private String kodeVoucher;
	private int harga;

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public String getKodeVoucher() {
		return kodeVoucher;
	}

	public void setKodeVoucher(String kodeVoucher) {
		this.kodeVoucher = kodeVoucher;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

}
