package com.dev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dev.dbconfig.DBConfig;
import com.dev.model.User;

public class UserService {
	
	public boolean addUser(User user) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into user (username, useremail, userpassword, usergender, userrole, useractive)"
													 + " values (?,?,?,?,?,?)");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUseremail());
			ps.setString(3, user.getUserpassword());
			ps.setString(4, user.getUsergender());
			ps.setString(5, "buyer");
			ps.setBoolean(6, false);
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("update user set username=? useremail=? userpassword=?"
													 + " where userid=?");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUseremail());
			ps.setString(3, user.getUserpassword());
			ps.setInt(6, user.getUserid());
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public User getUserById(int id) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from user where userid=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUseremail(rs.getString("useremail"));
				user.setUsergender(rs.getString("usergender"));
				user.setUserrole(rs.getString("userrole"));
				user.setUseractive(rs.getBoolean("useractive"));
				return user;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public User getUserByEmail(String email) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from user where useremail=? limit 1");
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUseremail(rs.getString("useremail"));
				user.setUsergender(rs.getString("usergender"));
				user.setUserrole(rs.getString("userrole"));
				user.setUseractive(rs.getBoolean("useractive"));
				return user;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public User getUserByLoginCredentials(String email, String password) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from user where useremail=? and userpassword=? and useractive=true limit 1");
			
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUseremail(rs.getString("useremail"));
				user.setUsergender(rs.getString("usergender"));
				user.setUserrole(rs.getString("userrole"));
				user.setUseractive(rs.getBoolean("useractive"));
				return user;
			}
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public boolean activateAccount(int userid) {
		try {
			Connection conn=DBConfig.getConnection();
			PreparedStatement ps=conn.prepareStatement("update user set useractive=true "
													 + "where userid=?");
			ps.setInt(1, userid);
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
