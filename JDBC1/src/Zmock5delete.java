import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Zmock5delete {
	public static void main(String [] args)throws Exception{
		Connection con=Driver.getConnection();
		String s="delete from employee where emp_id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int emp_id=sc.nextInt();
		pstmt.setInt(1, emp_id);
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
	}

}
