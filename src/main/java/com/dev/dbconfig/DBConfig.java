package com.dev.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
	
	public static Connection getConnection(){
		Connection conn=null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/shirtalogue", "exdeveloper", "#3exdeveloper");
		}
		catch(Exception e){
			e.printStackTrace();
			conn=null;
		}
		
		return conn;
	}
}
