package com.lawencon.penjualantiket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transaction_detail")
public class TransactionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;

	@ManyToOne
	@JoinColumn(name = "headerId", nullable = false)
	private TransactionHeader transactionHeader;

	@ManyToOne
	@JoinColumn(name = "typeId", nullable = false)
	private Type typeKendaraan;
	private String nama;
	private String tglKeberangakatan;

	private String seatNumber;

	@ManyToOne
	@JoinColumn(name = "hargaId", nullable = false)
	private HargaTiket hargaTiket;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTglKeberangakatan() {
		return tglKeberangakatan;
	}

	public void setTglKeberangakatan(String tglKeberangakatan) {
		this.tglKeberangakatan = tglKeberangakatan;
	}


	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public TransactionHeader getTransactionHeader() {
		return transactionHeader;
	}

	public void setTransactionHeader(TransactionHeader transactionHeader) {
		this.transactionHeader = transactionHeader;
	}

	public Type getTypeKendaraan() {
		return typeKendaraan;
	}

	public void setTypeKendaraan(Type typeKendaraan) {
		this.typeKendaraan = typeKendaraan;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public HargaTiket getHargaTiket() {
		return hargaTiket;
	}

	public void setHargaTiket(HargaTiket hargaTiket) {
		this.hargaTiket = hargaTiket;
	}

}
