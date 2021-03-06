package com.aroha.kams.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.kams.config.AppConfig;
import com.aroha.kams.model.UserEntity;
import com.aroha.kams.payload.UserPayload;
import com.aroha.kams.repository.UserRepository;

@Service
public class HomeService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	AppConfig appConfig;

	public Boolean findEmail(String eMail) {
		return userRepo.existsByeMail(eMail);
	}

	public UserPayload checkLogin(UserPayload userPayload) {
		UserEntity user = userRepo.findById(userPayload.geteMail()).orElse(new UserEntity());
		// Check For The Default Admin
		/*
		 * if (userPayload.geteMail().equalsIgnoreCase(appConfig.getAdminEmail()) &&
		 * userPayload.getUserPwd().equals(appConfig.getAdminPassword())) {
		 * userPayload.setMsg("Login As Admin"); userPayload.setStatus("success");
		 * return userPayload;
		 */
		if (user.geteMail().equalsIgnoreCase(userPayload.geteMail())
				&& user.getUserPwd().equals(userPayload.getUserPwd())) {
			userPayload.setMsg("Login As User");
			userPayload.setStatus("success");
			userPayload.seteMail(user.geteMail());
			userPayload.setUserName(user.getUserName());
			userPayload.setUserCompany(user.getUserCompany());
			userPayload.setUserdepartment(user.getUserdepartment());
			userPayload.setUserProjectName(user.getUserProjectName());
			userPayload.setUserTeamName(user.getUserTeamName());
			userPayload.setUserRole(user.getUserRole());
			Date date = new Date();
			System.out.println(date.toInstant());
			/*
			 * String strDateFormat = "hh-mm-ss a"; DateFormat dateFormat = new
			 * SimpleDateFormat(strDateFormat); String formattedDate=
			 * dateFormat.format(date); System.out.println(formattedDate); Date dateDate;
			 * try { dateDate = dateFormat.parse(formattedDate);
			 * System.out.println(dateDate); } catch (ParseException e) {
			 * e.printStackTrace(); }
			 */
			return userPayload;
		} else {
			userPayload.setMsg("Password Incorrect");
			userPayload.setStatus("error");
			return userPayload;
		}
	}

}
