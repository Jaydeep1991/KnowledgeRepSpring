package com.aroha.kams.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.kams.model.OtpEntity;
import com.aroha.kams.model.UserEntity;
import com.aroha.kams.otpGenerator.RandomString;
import com.aroha.kams.payload.OtpPayload;
import com.aroha.kams.payload.UserPayload;
import com.aroha.kams.repository.OtpRepository;
import com.aroha.kams.repository.UserRepository;

@Service
public class OtpService {

	@Autowired
	RandomString randString;

	@Autowired
	SendEmailService sendEmailService;

	@Autowired
	OtpRepository otpRepository;

	@Autowired
	UserRepository userRepository;

	/*
	 * public OtpPayload CreatePwd(OtpPayload otpPayload) { String pwd =
	 * randString.getAlphaNumericString(); String email =
	 * otpPayload.geteMailForOtp(); otpPayload.setOtpGenerated(pwd); boolean status
	 * = sendEmailService.sendOtp(email, pwd); if (status) { return otpPayload; }
	 * else { return new OtpPayload(); } }
	 */

	public String CreatePwd(UserPayload userPayload) {
		String pwd = randString.getAlphaNumericString();
		return pwd;
	}

	public OtpPayload CreateOtp(OtpPayload otpPayload) {
		Random r = new Random(System.currentTimeMillis());
		int otpGenerated = (1 + r.nextInt(2)) * 100000 + r.nextInt(100000);
		otpPayload.setOtpInt(otpGenerated);
		otpPayload.setMsg(sendEmailService.sendOtpInt(otpPayload.geteMailForOtp(), otpPayload.getOtpInt()));
		otpPayload.setStatus(200);
		OtpEntity getOtpEntity = otpRepository.findByeMail(otpPayload.geteMailForOtp());
		getOtpEntity.seteMail(otpPayload.geteMailForOtp());
		getOtpEntity.setOtpGenerated(otpGenerated);
		otpRepository.save(getOtpEntity);
		return (otpPayload);
	}

	public OtpPayload validateOtp(OtpPayload otpPayload) {
		OtpEntity getOtpEntity = otpRepository.findByeMail(otpPayload.geteMailForOtp());
		if (getOtpEntity.geteMail().equalsIgnoreCase(otpPayload.geteMailForOtp())
				&& getOtpEntity.getOtpGenerated() == otpPayload.getOtpInt()) {
			UserEntity userEntity = userRepository.findByeMail(otpPayload.geteMailForOtp());
			userEntity.setUserPwd(otpPayload.getNewPassword());
			userRepository.save(userEntity);
			otpPayload.setMsg("Password Updated");
			otpPayload.setStatus(200);
		} else {
			otpPayload.setMsg("Otp Incorrect");
			otpPayload.setStatus(200);
		}
		return (otpPayload);
	}

}
