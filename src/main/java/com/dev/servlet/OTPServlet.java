package com.dev.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.OTP;
import com.dev.service.OTPService;
import com.dev.service.UserService;

@WebServlet(name="OTPServlet", urlPatterns="/OTPServlet")
public class OTPServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		try {
			int otpid = Integer.parseInt(req.getParameter("otpid"));
			String otpcode = req.getParameter("otpcode");
			
			OTP tempotp = new OTP();
			OTPService os = new OTPService();
			UserService userService = new UserService();
			
			tempotp = os.getOTPRecordById(otpid);
			userService.activateAccount(tempotp.getUserid());
			
			//Success
			pw.println("<script>"
					+  "alert('Account activated. Please Login!');"
					+  "window.location='login.jsp';"
					+  "</script>");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Failure		
		pw.println("<script>"
				+  "alert('Something went wrong. Please try again later!');"
				+  "window.location='home.jsp';"
				+  "</script>");
	}
}
