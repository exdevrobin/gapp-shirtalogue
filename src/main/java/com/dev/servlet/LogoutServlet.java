package com.dev.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		HttpSession hs = req.getSession();
		
		try {
	        if (hs!=null) {
				hs.removeAttribute("logid");
				hs.removeAttribute("logname");
				hs.removeAttribute("logrole");
				hs.removeAttribute("message");
				hs.removeAttribute("formerror");
				hs.invalidate();
	         }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		pw.println("<script>"
				+  "alert('Logged out!');"
				+  "window.location='login.jsp';"
				+  "</script>");
	}
}
