package com.dev.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Product;
import com.dev.service.ProductService;

@WebServlet(name = "ProductListServlet", urlPatterns = "/productlist")
public class ProductListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List productlist = new ArrayList<Product>();
		ProductService ps = new ProductService();
		
		productlist = ps.getProductList();
		req.setAttribute("productlist", productlist);
		req.getRequestDispatcher("productlist.jsp").forward(req, resp);
	}
}
