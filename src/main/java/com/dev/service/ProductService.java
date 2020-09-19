package com.dev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dev.dbconfig.DBConfig;
import com.dev.model.Product;

public class ProductService {
	
	public boolean addProduct(Product product) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into product ("
													 + "productname, productbrand, productdesc, productfit, productcolor, "
												     + "stock_xs, stock_s, stock_m, stock_l, stock_xl, stock_2xl, "
												     + "price_xs, price_s, price_m, price_l, price_xl, price_2xl) "
													 + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, product.getProductname());
			ps.setString(2, product.getProductbrand());
			ps.setString(3, product.getProductdesc());
			ps.setString(4, product.getProductfit());
			ps.setString(5, product.getProductcolor());
			ps.setInt(6, product.getStock_xs());
			ps.setInt(7, product.getStock_s());
			ps.setInt(8, product.getStock_m());
			ps.setInt(9, product.getStock_l());
			ps.setInt(10, product.getStock_xl());
			ps.setInt(11, product.getStock_2xl());
			ps.setDouble(12, product.getPrice_xs());
			ps.setDouble(13, product.getPrice_s());
			ps.setDouble(14, product.getPrice_m());
			ps.setDouble(15, product.getPrice_l());
			ps.setDouble(16, product.getPrice_xl());
			ps.setDouble(17, product.getPrice_2xl());
			
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateProduct(Product product) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("update product set "
													 + "productname=?, productbrand=?, productdesc=?, productfit=?, productcolor=?, "
													 + "stock_xs=?, stock_s=?, stock_m=?, stock_l=?, stock_xl=?, stock_2xl=?, "
													 + "price_xs=?, price_s=?, price_m=?, price_l=?, price_xl=?, price_2xl=? "
													 + "where productid=?");
			
			ps.setString(1, product.getProductname());
			ps.setString(2, product.getProductbrand());
			ps.setString(3, product.getProductdesc());
			ps.setString(4, product.getProductfit());
			ps.setString(5, product.getProductcolor());
			ps.setInt(6, product.getStock_xs());
			ps.setInt(7, product.getStock_s());
			ps.setInt(8, product.getStock_m());
			ps.setInt(9, product.getStock_l());
			ps.setInt(10, product.getStock_xl());
			ps.setInt(11, product.getStock_2xl());
			ps.setDouble(12, product.getPrice_xs());
			ps.setDouble(13, product.getPrice_s());
			ps.setDouble(14, product.getPrice_m());
			ps.setDouble(15, product.getPrice_l());
			ps.setDouble(16, product.getPrice_xl());
			ps.setDouble(17, product.getPrice_2xl());
			ps.setInt(18, product.getProductid());
			
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Product getProductById(int id) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from product where productid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setProductbrand(rs.getString("productbrand"));
				product.setProductdesc(rs.getString("productdesc"));
				product.setProductfit(rs.getString("productfit"));
				product.setProductcolor(rs.getString("productcolor"));

				product.setStock_xs(rs.getInt("stock_xs"));
				product.setStock_s(rs.getInt("stock_s"));
				product.setStock_m(rs.getInt("stock_m"));
				product.setStock_l(rs.getInt("stock_l"));
				product.setStock_xl(rs.getInt("stock_xl"));
				product.setStock_2xl(rs.getInt("stock_2xl"));
				
				product.setPrice_xs(rs.getDouble("stock_xs"));
				product.setPrice_s(rs.getDouble("stock_s"));
				product.setPrice_m(rs.getDouble("stock_m"));
				product.setPrice_l(rs.getDouble("stock_l"));
				product.setPrice_xl(rs.getDouble("stock_xl"));
				product.setPrice_2xl(rs.getDouble("stock_2xl"));
				
				return product;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<Product> getProductList() {
		try {
			Product product = new Product();
			List<Product> productList = new ArrayList<Product>();
			
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setProductbrand(rs.getString("productbrand"));
				product.setProductdesc(rs.getString("productdesc"));
				product.setProductfit(rs.getString("productfit"));
				product.setProductcolor(rs.getString("productcolor"));

				product.setStock_xs(rs.getInt("stock_xs"));
				product.setStock_s(rs.getInt("stock_s"));
				product.setStock_m(rs.getInt("stock_m"));
				product.setStock_l(rs.getInt("stock_l"));
				product.setStock_xl(rs.getInt("stock_xl"));
				product.setStock_2xl(rs.getInt("stock_2xl"));
				
				product.setPrice_xs(rs.getDouble("stock_xs"));
				product.setPrice_s(rs.getDouble("stock_s"));
				product.setPrice_m(rs.getDouble("stock_m"));
				product.setPrice_l(rs.getDouble("stock_l"));
				product.setPrice_xl(rs.getDouble("stock_xl"));
				product.setPrice_2xl(rs.getDouble("stock_2xl"));
				
				productList.add(product);
			}
			return productList;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public int getProductCount() {
		try {
			int count=0;
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select count(*) as 'productcount' from product");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("productcount");
			}
			return count;
		}
		catch(Exception e) {
			return 0;
		}
	}
}
