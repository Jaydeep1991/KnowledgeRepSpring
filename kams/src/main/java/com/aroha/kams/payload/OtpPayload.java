package com.aroha.kams.payload;

public class OtpPayload {
	// private String otpGenerated;
	private String eMailForOtp;
	// private String otpEntered;
	private String newPassword;
	private int otpInt;
	private int status;
	private String msg;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String geteMailForOtp() {
		return eMailForOtp;
	}

	public void seteMailForOtp(String eMailForOtp) {
		this.eMailForOtp = eMailForOtp;
	}

	public int getOtpInt() {
		return otpInt;
	}

	public void setOtpInt(int otpInt) {
		this.otpInt = otpInt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}