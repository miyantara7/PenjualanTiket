package com.lawencon.penjualantiket.controller;
/*
 * @author I KADEK ARYA YOGIMIYAANTARA
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import com.lawencon.penjualantiket.service.HargaTiketService;
import com.lawencon.penjualantiket.service.TransactionService;
import com.lawencon.penjualantiket.service.TypeService;
import com.lawencon.penjualantiket.service.UserService;
import com.lawencon.penjualantiket.service.VoucherTiketService;

abstract class BaseController {

	@Autowired
	protected TransactionService t_service;
	@Autowired
	protected UserService u_service;
	@Autowired
	protected HargaTiketService h_service;
	@Autowired
	protected VoucherTiketService v_service;
	@Autowired
	protected TypeService tp_service;
	abstract String authUser(String user) throws Exception;
}
