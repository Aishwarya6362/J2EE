
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
			String s="insert into student values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, marks1);
			ps.setInt(4, marks2);
			ps.setInt(5, marks3);
			int rows=ps.executeUpdate();
			PrintWriter out=response.getWriter();
			if(rows==0) {
				out.println("student data not added");
			}
			else {
				out.println("Student data added successfully");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}