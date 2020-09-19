package com.dev.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.OTP;
import com.dev.model.User;
import com.dev.service.EmailService;
import com.dev.service.OTPService;
import com.dev.service.UserService;

@WebServlet(name="RegistrationServlet", urlPatterns = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "";
		
		User user = new User();
		OTPService otpService = new OTPService();
		UserService userService=new UserService();
		
		//Extract Data from request
		user.setUsername(req.getParameter("username"));
		user.setUsergender(req.getParameter("usergender"));
		user.setUseremail(req.getParameter("useremail"));
		user.setUserpassword(req.getParameter("userpassword"));
		user.setUserrole("buyer");
		user.setUseractive(false);
		
		if(userService.getUserByEmail(user.getUseremail())!=null) {
			//Dont allow this scenario. or handle this in AJAX
			System.out.println("Email Exists!!" + "**********************************************");
		}

		try {
			//Add User
			if(userService.addUser(user)) {
				
				//get current user object with generated user-id
				User newuser = userService.getUserByEmail(user.getUseremail());
				
				//Generate OTP
				OTP otp = new OTP();
				otp.setOtpcode((new Random().nextInt(900000) + 100000) + "");
				otp.setEmail(user.getUseremail());
				otp.setUserid(newuser.getUserid());
				
				otp = otpService.generateOTP(otp);		
				
//to be removed
System.out.println(otp.getOtpcode() + "*************************************************");
				
				//Send Verification Email
				EmailService emailObj = new EmailService(user.getUseremail(), 
														 "OTP Code for Shirtalogue account activation", 
															 
														 "Hi " + user.getUsername() + "," +
														 "\r\n\r\nYour OTP Code for Shirtalogue account activation is: " + otp.getOtpcode() +
														 "\r\n\r\nIf you have closed the OTP page, Click here: http://localhost:8080/processotp?id=" + otp.getOtpid());
				emailObj.sendEmail();
				//Success Scenario
				req.getRequestDispatcher("otp.jsp?otpid=" + otp.getOtpid()).forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Failure Scenario
		message = "Registration Unsuccessful. Please Try after some time!!";
		req.setAttribute("message", message);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
