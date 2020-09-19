package com.dev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.ProductService;

@WebServlet(name = "UpdateProductFormServlet", urlPatterns = "/updateproduct")
public class UpdateProductFormServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("productid"));
			ProductService ps = new ProductService();
			
			req.setAttribute("product", ps.getProductById(id));
			req.getRequestDispatcher("productform.jsp").forward(req, resp);	
		}
		catch(Exception e) {
			req.getRequestDispatcher("/adminpanel").forward(req, resp);	
		}
	}
}
