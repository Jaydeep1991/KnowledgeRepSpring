package com.aroha.kams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otp_details")
public class OtpEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int otp_Id;
	private String eMail;
	private int otpGenerated;

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getOtpGenerated() {
		return otpGenerated;
	}

	public void setOtpGenerated(int otpGenerated) {
		this.otpGenerated = otpGenerated;
	}
}
