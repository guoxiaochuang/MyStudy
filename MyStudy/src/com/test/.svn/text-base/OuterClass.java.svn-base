package com.test;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import oracle.jdbc.driver.OracleDriver;
public class OuterClass {
	
	String url = "";
	String user = "";
	String password = "";
	Connection c = null;
	Statement conn;
	ResultSet rs = null;
	public void jdbc(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			c = (Connection) DriverManager.getConnection(url, user, password);
			conn = (Statement) c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean executeUpdate(String sql){
		try {
			conn.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
