import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Zmock2Read {
	public static void main(String [] args)throws Exception{
		Connection con=Driver.getConnection();
		String s="select * from employee where emp_id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id:");
		int emp_id=sc.nextInt();
		pstmt.setInt(1,emp_id);
		ResultSet res=pstmt.executeQuery();
		if(res.next()==true) {
			emp_id=res.getInt(1);
			String emp_name=res.getString(2);
			String place=res.getString(3);
			System.out.println(emp_id+" "+emp_name+" "+place);
		}
	}
}