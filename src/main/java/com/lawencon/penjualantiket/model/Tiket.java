package com.lawencon.penjualantiket.model;

public class Tiket {

	private int transactionId;
	private String nama;
	private String tglBerangkat;
	private String seatNumber;
	private Type typeKendaraan;
	
	
	public Type getTypeKendaraan() {
		return typeKendaraan;
	}

	public void setTypeKendaraan(Type typeKendaraan) {
		this.typeKendaraan = typeKendaraan;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTglBerangkat() {
		return tglBerangkat;
	}

	public void setTglBerangkat(String tglBerangkat) {
		this.tglBerangkat = tglBerangkat;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

}
