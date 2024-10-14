//inserting the values to student table.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class pgm3insert {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("driver loaded ");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
		System.out.println("Connection done");
		String s="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s);//create
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id: ");
		int emp_id=sc.nextInt();
		System.out.println("enter the name: ");
		String name=sc.next();
		System.out.println("enter the marks1: ");
		int marks1=sc.nextInt();
		System.out.println("enter the marks2: ");
		int marks2=sc.nextInt();
		System.out.println("enter the marks3: ");
		int marks3=sc.nextInt();
		pstmt.setInt(1, emp_id);
		pstmt.setString(2, name);
		pstmt.setInt(3,marks1);
		pstmt.setInt(4,marks2);
		pstmt.setInt(5,marks3);
		int rows=pstmt.executeUpdate();//execute
		System.out.println(rows);
	}
}