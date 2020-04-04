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
import com.lawencon.penjualantiket.model.Customer;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Override
	String authUser(String user) throws Exception {
		byte[] decodedBytes = Base64.getDecoder().decode(user);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}

	@PostMapping("/insertuser")
	public ResponseEntity<?> insertUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.insertUserHiber(customer, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/edituser")
	public ResponseEntity<?> editUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("username") String user2) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.editUserHiber(customer, auth[0], auth[1], user2);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteuser")
	public ResponseEntity<?> deleteUserHiber(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.deleteUserHiber(customer, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listuser")
	public ResponseEntity<?> viewUserHiber(@RequestHeader("Authorization") String user) {
		List<Customer> listUser = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listUser = u_service.viewUserHiber(auth[0], auth[1]);
			return new ResponseEntity<>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listUser, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/insertuser/Jpa")
	public ResponseEntity<?> insertUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.insertUserJpa(customer, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/edituser/Jpa")
	public ResponseEntity<?> editUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user,
			@RequestParam("username") String user2) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.editUserJpa(customer, auth[0], auth[1], user2);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteuser/Jpa")
	public ResponseEntity<?> deleteUserJpa(@RequestBody String content, @RequestHeader("Authorization") String user) {
		String pesan = "";
		try {
			String[] auth = authUser(user).split(":");
			Customer customer = new ObjectMapper().readValue(content, Customer.class);
			pesan = u_service.deleteUserJpa(customer, auth[0], auth[1]);
			return new ResponseEntity<>(pesan, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(pesan, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listuser/Jpa")
	public ResponseEntity<?> viewUserJpa(@RequestHeader("Authorization") String user) {
		List<Customer> listUser = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listUser = u_service.viewUserJpa(auth[0], auth[1]);
			return new ResponseEntity<>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listUser, HttpStatus.BAD_REQUEST);
		}

	}

}
