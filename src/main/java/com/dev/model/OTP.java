package com.dev.model;

public class OTP {

	private int otpid;
	private int userid;
	private String email;
	private String otpcode;
	
	public int getOtpid() {
		return otpid;
	}
	public void setOtpid(int otpid) {
		this.otpid = otpid;
	}
	public String getOtpcode() {
		return otpcode;
	}
	public void setOtpcode(String otpcode) {
		this.otpcode = otpcode;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
