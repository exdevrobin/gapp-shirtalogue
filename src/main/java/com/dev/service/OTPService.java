package com.dev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dev.dbconfig.DBConfig;
import com.dev.model.OTP;

public class OTPService {
	
	public OTP generateOTP(OTP otp) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into otp (userid, email, otpcode) "
													 + "values (?,?,?)");
			
			ps.setInt(1, otp.getUserid());
			ps.setString(2, otp.getEmail());
			ps.setString(3, otp.getOtpcode());
			ps.executeUpdate();
			
			return getOTPRecordByEmail(otp.getEmail());
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public OTP getOTPRecordById(int id) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from otp where otpid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			OTP otp = new OTP();
			if(rs.next()) {
				otp.setOtpid(rs.getInt("otpid"));
				otp.setUserid(rs.getInt("userid"));
				otp.setEmail(rs.getString("email"));
				otp.setOtpcode(rs.getString("otpcode"));
			}
			return otp;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//This must be only used to fetch within generateOTP Function
	public OTP getOTPRecordByEmail(String email) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from otp where email=? order by otpid desc limit 1");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			OTP otp = new OTP();
			if(rs.next()) {
				otp.setOtpid(rs.getInt("otpid"));
				otp.setUserid(rs.getInt("userid"));
				otp.setEmail(rs.getString("email"));
				otp.setOtpcode(rs.getString("otpcode"));
			}
			return otp;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
