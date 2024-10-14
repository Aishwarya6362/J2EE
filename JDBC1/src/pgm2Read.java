//Demo: Accessing individual result of a student.,read
//prepareStatement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class pgm2Read {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("driver loaded ");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
		System.out.println("Connection done");
		String s="select * from student where id=?";// SQL query with a placeholder (?) for employee ID.
		PreparedStatement pstmt=con.prepareStatement(s);// Prepare the query with the connection.
		System.out.println("enter the id:");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		pstmt.setInt(1,id); // Set the employee ID in the prepared statement.
		ResultSet res=pstmt.executeQuery();// Execute the query and get the results.
		// Check if there is a result and print employee details.
		if(res.next()) {
			id=res.getInt(1);
			String name=res.getString(2);
			int marks1=res.getInt(3);
			int marks2=res.getInt(4);
			int marks3=res.getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
		}	
		else 
		{
			System.out.println("invalid");
		}
	}
}
