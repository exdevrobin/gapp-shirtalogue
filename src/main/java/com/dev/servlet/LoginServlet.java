package com.dev.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.model.User;
import com.dev.service.UserService;

@WebServlet(name = "/LoginServlet" , urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email="", password="";
		UserService userService = new UserService();
		PrintWriter pw = resp.getWriter();
		
		try {
			email = req.getParameter("email");
			password = req.getParameter("password");
			
			User user = userService.getUserByLoginCredentials(email, password);
			
			if(user!=null) {		
				System.out.println("User not null");
				
				HttpSession hs = req.getSession();
				hs.setAttribute("logid", user.getUserid());
				hs.setAttribute("logname", user.getUsername());
				hs.setAttribute("logrole", user.getUserrole());

				pw.println("<script>"
						+  "alert('Logged in!');"
						+  "window.location='home.jsp';"
						+  "</script>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception!!");
		}
		
		pw.println("<script>"
				+  "alert('Something went wrong. Please check the credentials!');"
				+  "window.location='login.jsp';"
				+  "</script>");
	}
}
