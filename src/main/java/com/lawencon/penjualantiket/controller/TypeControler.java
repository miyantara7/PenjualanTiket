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
import com.lawencon.penjualantiket.model.Type;

@RestController
@RequestMapping("/type")
public class TypeControler extends BaseController {

	@Override
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@PostMapping("/inserttype")
	public ResponseEntity<?> insertTypeHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.insertTypeHiber(typeKendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/edittype")
	public ResponseEntity<?> editTypeHiber(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("typeId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.editTypeHiber(typeKendaraan, auth[0], auth[1], id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deletetype")
	public ResponseEntity<?> deleteTypeHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.deleteTypeHiber(typeKendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listtype")
	public ResponseEntity<?> viewTypeHiber(@RequestHeader("Authorization") String user) {
		List<Type> listType = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listType = tp_service.viewTypeHiber(auth[0], auth[1]);
			return new ResponseEntity<>(listType, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listType, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/inserttype/jpa")
	public ResponseEntity<?> insertTypeJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.insertTypeJpa(typeKendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/edittype/jpa")
	public ResponseEntity<?> editTypeJpa(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("typeId") int id) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.editTypeJpa(typeKendaraan, auth[0], auth[1], id);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deletetype/jpa")
	public ResponseEntity<?> deleteTypeJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Type typeKendaraan = new ObjectMapper().readValue(content, Type.class);
			pesan = tp_service.deleteTypeJpa(typeKendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listtype/jpa")
	public ResponseEntity<?> viewTypeJpa(@RequestHeader("Authorization") String user) {
		List<Type> listType = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listType = tp_service.viewTypeJpa(auth[0], auth[1]);
			return new ResponseEntity<>(listType, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listType, HttpStatus.BAD_REQUEST);
		}

	}
}
