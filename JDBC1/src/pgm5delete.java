import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class pgm5delete {
	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("driver loaded successfully");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
		System.out.println("connection established successfully");
		String s="delete from student where id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the id: ");
		int id=scan.nextInt();
		pstmt.setInt(1, id);
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
	}
}
