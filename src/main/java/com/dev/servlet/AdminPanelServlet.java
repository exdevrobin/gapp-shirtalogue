package com.dev.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Order;
import com.dev.model.Product;
import com.dev.service.ProductService;

@WebServlet(name = "AdminPanelServlet", urlPatterns = "/adminpanel")
public class AdminPanelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productcount=0, ordercount=0, pendingcount=0;
		List orderlist = new ArrayList<Order>();
		List pendinglist = new ArrayList<Product>();
		ProductService ps = new ProductService();
		
		//Get Product Details
		productcount = ps.getProductCount();
		req.setAttribute("productcount", productcount);		
		
		//Order Details
		ordercount = 100;
		pendingcount = 100;
		req.setAttribute("ordercount", ordercount);				//Orders that  does not requires attention	

		req.getRequestDispatcher("adminpanel.jsp").forward(req, resp);
	}
}
