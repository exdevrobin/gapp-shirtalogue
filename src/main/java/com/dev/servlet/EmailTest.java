package com.dev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dev.service.EmailService;

@WebServlet("/testemail")
public class EmailTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//Send Verification Email
			EmailService emailObj = new EmailService("exdev.robin@outlook.com", 
												 "OTP Code for Shirtalogue account activation", 
													 
												 "Hi Name," +
												 "\r\n\r\nYour OTP Code for Shirtalogue account activation is: " + 
												 "\r\n\r\nIf you have closed the OTP page, Click here: http://localhost:8080/otp.jsp?id=1");
			System.out.println("About to send mail");
			emailObj.sendEmail();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("exception occured");
		}

		System.out.println("redirecting to home");
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
