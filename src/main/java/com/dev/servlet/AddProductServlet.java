package com.dev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.Product;
import com.dev.service.ProductService;

@WebServlet(name = "AddProductServlet", urlPatterns = "/AddProductServlet")
public class AddProductServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String formerror = "";
		String message = "";
		Product product=new Product();
		ProductService ps=new ProductService();
		
		//Extract Data from Request
		product.setProductname(req.getParameter("productname"));
		product.setProductbrand(req.getParameter("productbrand"));
		product.setProductdesc(req.getParameter("productdesc"));
		product.setProductfit(req.getParameter("productfit"));
		product.setProductcolor(req.getParameter("productcolor"));

		product.setStock_xs(Integer.parseInt(req.getParameter("stock_xs")));
		product.setStock_s(Integer.parseInt(req.getParameter("stock_s")));
		product.setStock_m(Integer.parseInt(req.getParameter("stock_m")));
		product.setStock_l(Integer.parseInt(req.getParameter("stock_l")));
		product.setStock_xl(Integer.parseInt(req.getParameter("stock_xl")));
		product.setStock_2xl(Integer.parseInt(req.getParameter("stock_2xl")));
		
		product.setPrice_xs(Double.parseDouble(req.getParameter("price_xs")));
		product.setPrice_s(Double.parseDouble(req.getParameter("price_s")));
		product.setPrice_m(Double.parseDouble(req.getParameter("price_m")));
		product.setPrice_l(Double.parseDouble(req.getParameter("price_l")));
		product.setPrice_xl(Double.parseDouble(req.getParameter("price_xl")));
		product.setPrice_2xl(Double.parseDouble(req.getParameter("price_2xl")));
		
		//Validate Data
		if("".equals(product.getProductbrand())) {
			product.setProductbrand("Unknown");
		}
		
		if("".equals(product.getProductname())){
			formerror = "Product Name is mandatory!";
		}
		else if(ps.addProduct(product)) {	//Inserted Successfully
			message = "Product Added!";
			req.setAttribute("message", message);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/adminpanel").forward(req, resp);
		}
		else {	// Failed to Update
			message = "Something went wrong. Please try later!";
			req.setAttribute("message", message);
			req.getRequestDispatcher("/adminpanel").forward(req, resp);
		}

		req.setAttribute("formerror", formerror);
		req.setAttribute("product", product);
		req.getRequestDispatcher("productform.jsp").forward(req, resp);
	}
}
