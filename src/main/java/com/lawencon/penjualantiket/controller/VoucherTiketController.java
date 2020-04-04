package com.lawencon.penjualantiket.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.penjualantiket.model.VoucherTiket;

@RestController
@RequestMapping("/voucher")
public class VoucherTiketController extends BaseController {

	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@PostMapping("/insertvoucher")
	public ResponseEntity<?> insertUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.insertVoucherTiketHiber(pocerTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/editvoucher")
	public ResponseEntity<?> editUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("voucherId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.editVoucherTiketHiber(pocerTiket, auth[0], auth[1], id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deletevoucher")
	public ResponseEntity<?> deleteUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.deleteVoucherTiketHiber(pocerTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listvoucher")
	public ResponseEntity<?> viewUserHiber(@RequestHeader("Authorization") String user) {
		List<VoucherTiket> listVoucher = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listVoucher = v_service.viewVoucherTiketHiber(auth[0], auth[1]);
			return new ResponseEntity<>(listVoucher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listVoucher, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/insertvoucher/Jpa")
	public ResponseEntity<?> insertUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.insertVoucherTiketJpa(pocerTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/editvoucher/Jpa")
	public ResponseEntity<?> editUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("voucherId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.editVoucherTiketJpa(pocerTiket, auth[0], auth[1],id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deletevoucher/Jpa")
	public ResponseEntity<?> deleteUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			VoucherTiket pocerTiket = new ObjectMapper().readValue(content, VoucherTiket.class);
			pesan = v_service.deleteVoucherTiketJpa(pocerTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listvoucher/Jpa")
	public ResponseEntity<?> viewUserJpa(@RequestHeader("Authorization") String user) {
		List<VoucherTiket> listVoucher = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listVoucher = v_service.viewVoucherTiketHiber(auth[0], auth[1]);
			return new ResponseEntity<>(listVoucher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listVoucher, HttpStatus.BAD_REQUEST);
		}

	}
}
