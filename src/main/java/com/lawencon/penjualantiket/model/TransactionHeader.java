package com.lawencon.penjualantiket.model;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_transaction_header", uniqueConstraints = {
		@UniqueConstraint(name = "u_transaction", columnNames = { "transactionId" }) })
public class TransactionHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int headerId;
	private int transactionId;
	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;
	private BigInteger totalPembelian;
	@ManyToOne
	@JoinColumn(name = "voucherId", nullable = false)
	private VoucherTiket voucherTiket;
	
	public VoucherTiket getVoucherTiket() {
		return voucherTiket;
	}

	public void setVoucherTiket(VoucherTiket voucherTiket) {
		this.voucherTiket = voucherTiket;
	}

	public BigInteger getTotalPembelian() {
		return totalPembelian;
	}

	public void setTotalPembelian(BigInteger totalPembelian) {
		this.totalPembelian = totalPembelian;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

}
