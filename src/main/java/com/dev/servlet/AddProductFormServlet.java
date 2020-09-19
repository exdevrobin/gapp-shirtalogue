package com.dev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Product;

@WebServlet(name = "AddProductFormServlet", urlPatterns = "/addproduct")
public class AddProductFormServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setProductfit("Regular");
		p.setProductcolor("NA");
		req.setAttribute("product", p);
		req.getRequestDispatcher("productform.jsp").forward(req, resp);
	}
}
