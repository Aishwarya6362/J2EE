package com.qn.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Student;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id=Integer.parseInt(request.getParameter("id"));
	//request.getParameter("id")--> gives me the id in the string format.
	//we are converting id from string to integer by using parseInt().
	String name=request.getParameter("name");
	//name is required in the string format.so no need of converting.
	int marks1=Integer.parseInt(request.getParameter("marks1"));
	int marks2=Integer.parseInt(request.getParameter("marks2"));
	int marks3=Integer.parseInt(request.getParameter("marks3"));
	Student tempStudent=new Student();
	tempStudent.setId(id);
	tempStudent.setName(name);
	tempStudent.setMarks1(marks1);
	tempStudent.setMarks2(marks2);
	tempStudent.setMarks3(marks3);
	int rows=tempStudent.addResult();
		if(rows==1) {
			response.sendRedirect("/add-result-mvc/addResultSuccess.html");
		}
		else {
			response.sendRedirect("/add-result-mvc/addResultFailure.html");
		}
	}
}
