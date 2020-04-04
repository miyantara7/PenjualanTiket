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
import com.lawencon.penjualantiket.model.HargaTiket;

@RestController
@RequestMapping("/hargatiket")
public class HargaTiketController extends BaseController {

	@Override
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@PostMapping("/insertharga")
	public ResponseEntity<?> insertUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.insertHargaHiber(hargaTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/editharga")
	public ResponseEntity<?> editUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("hargaId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.editHargaHiber(hargaTiket, auth[0], auth[1], id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteharga")
	public ResponseEntity<?> deleteUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.deleteHargaHiber(hargaTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listharga")
	public ResponseEntity<?> viewUserHiber(@RequestHeader("Authorization") String user) {
		List<HargaTiket> listHarga = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listHarga = h_service.viewHargaHiber(auth[0], auth[1]);
			return new ResponseEntity<>(listHarga, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listHarga, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/insertharga/Jpa")
	public ResponseEntity<?> insertUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.insertHargaJpa(hargaTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/editharga/Jpa")
	public ResponseEntity<?> editUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("hargaId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.editHargaJpa(hargaTiket, auth[0], auth[1], id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteharga/Jpa")
	public ResponseEntity<?> deleteUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			HargaTiket hargaTiket = new ObjectMapper().readValue(content, HargaTiket.class);
			pesan = h_service.deleteHargaJpa(hargaTiket, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listharga/Jpa")
	public ResponseEntity<?> viewUserJpa(@RequestHeader("Authorization") String user) {
		List<HargaTiket> listHarga = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listHarga = h_service.viewHargaJpa(auth[0], auth[1]);
			return new ResponseEntity<>(listHarga, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listHarga, HttpStatus.BAD_REQUEST);
		}

	}
	
}
