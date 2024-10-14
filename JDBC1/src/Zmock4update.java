import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Zmock4update {
	public static void main(String [] args) throws Exception{
		Connection con=Driver.getConnection();
		String s="update employee set emp_name=? where emp_id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name: ");
		String emp_name=sc.next();
		System.out.println("enter id");
		int emp_id=sc.nextInt();
		pstmt.setString(1, emp_name);
		pstmt.setInt(2, emp_id);
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
	}
}
