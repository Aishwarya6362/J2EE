package com.qn.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Pgm1LaunchCRUD {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
		String s="select * from student";//query
		Statement stmt=con.createStatement();//just for retrieving
		ResultSet res=stmt.executeQuery(s);
	   ResultSetMetaData rsmd=(ResultSetMetaData) res.getMetaData();
	   for(int i=1;i<=rsmd.getColumnCount();i++) {
		   System.out.println(rsmd.getColumnName(i));
		   System.out.println(rsmd.getColumnTypeName(i));
	   }
	   while(res.next()==true) {
		   int id=res.getInt(1);
		   String name=res.getString(2);
		   int marks1=res.getInt(3);
		   int marks2=res.getInt(4);
		   int marks3=res.getInt(5);
		   System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
	   }
	}
}
