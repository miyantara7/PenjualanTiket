package com.lawencon.penjualantiket.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.penjualantiket.model.Tiket;
import com.lawencon.penjualantiket.model.TransactionDetail;

@RestController
@RequestMapping("/tiket")
public class TransactionController extends BaseController {

	@Override
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@PostMapping("/checkinJpa")
	public ResponseEntity<?> insertJpa(@RequestParam("pocer") String pocer, @RequestBody String content,
			@RequestHeader("Authorization") String user) {
		List<TransactionDetail> listTransaction = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			List<Tiket> listTiket = Arrays.asList(new ObjectMapper().readValue(content, Tiket[].class));
			listTransaction = t_service.insertTiketJpa(pocer,auth[0],auth[1],listTiket);
			return new ResponseEntity<>(listTransaction, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTransaction, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/checkinHiber")
	public ResponseEntity<?> insertHiber(@RequestParam("pocer") String pocer, @RequestBody String content,
			@RequestHeader("Authorization") String user) {
		List<TransactionDetail> listTransaction = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			List<Tiket> listTiket = Arrays.asList(new ObjectMapper().readValue(content, Tiket[].class));
			listTransaction = t_service.insertTiketHiber(pocer,auth[0],auth[1],listTiket);
			return new ResponseEntity<>(listTransaction, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTransaction, HttpStatus.BAD_REQUEST);
		}

	}

}
