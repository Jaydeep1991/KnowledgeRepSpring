package com.aroha.kams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aroha.kams.payload.OtpPayload;
import com.aroha.kams.payload.UserPayload;
import com.aroha.kams.repository.TopicRepository;
import com.aroha.kams.repository.UserRepository;
import com.aroha.kams.service.HomeService;
import com.aroha.kams.service.OtpService;


@RestController
@RequestMapping("/api/dropbox")
@CrossOrigin("*")
public class HomeController {

	@Autowired
	private HomeService homeService;

	@Autowired
	private OtpService otpService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TopicRepository topicRepository;

	@PostMapping("/checkLogin")
	public ResponseEntity<?> checkLogin(@RequestBody UserPayload userpayload) {
		Boolean isUserExists = homeService.findEmail(userpayload.geteMail());
		if (isUserExists) {
			UserPayload getUserpayload = homeService.checkLogin(userpayload);
			/*
			 * if(userpayload.getStatus().equalsIgnoreCase("success")) { //Get The Login
			 * Time
			 * 
			 * 
			 * }
			 */
			return ResponseEntity.ok(getUserpayload);	
		} else {
			userpayload.setStatus("Error");
			userpayload.setMsg("User Not Found");
			return ResponseEntity.ok(userpayload);
		}
	}

	@GetMapping("destroy")
	public String logout() {
		return null;
	}

	@PostMapping("/forgetPassword")
	public ResponseEntity<?> forgetPassword(@RequestBody OtpPayload otpPayload) {
		if (userRepository.existsByeMail(otpPayload.geteMailForOtp())) {
			otpPayload = otpService.CreateOtp(otpPayload);
		} else {
			otpPayload.setMsg("User Not Found");
			otpPayload.setStatus(500);
		}
		return ResponseEntity.ok(otpPayload);
	}

	@PostMapping("/validateOtp")
	public ResponseEntity<?> validiateOtp(@RequestBody OtpPayload otpPayload) {
		otpPayload = otpService.validateOtp(otpPayload);
		return ResponseEntity.ok(otpPayload);
	}
	
	@GetMapping("showTopic")
	public ResponseEntity<?> showAllTopic(){
		return ResponseEntity.ok(topicRepository.findAll());
	}

}