import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Zmock3insert {
	public static void main(String[] args)throws Exception{
		Connection con=Driver.getConnection();
		String s="insert into employee values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the emp id: ");
		int id=sc.nextInt();
		System.out.println("enter the emp name: ");
		String emp_name=sc.next();
		System.out.println("enter place: ");
		String place=sc.next();
		pstmt.setInt(1,id);
		pstmt.setString(2, emp_name);
		pstmt.setString(3,place);
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
	}
}