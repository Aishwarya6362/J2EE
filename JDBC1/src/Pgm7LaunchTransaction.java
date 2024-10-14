import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pgm7LaunchTransaction {
	public static void main(String[] args) throws Exception {
//		Connection con=Driver.getConnection();
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root", 
				"123456789");
		Scanner sc=new Scanner(System.in);
		con.setAutoCommit(false);
			String s1="insert into student values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s1);
			System.out.println("enter id");
			int id=sc.nextInt();
			System.out.println("entern the name");
			String name=sc.next();
			System.out.println("enter marks1");
			int marks1=sc.nextInt();
			System.out.println("enter marks2");
			int marks2=sc.nextInt();
			System.out.println("enter marks3");
			int marks3=sc.nextInt();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, marks1);
			ps.setInt(4, marks2);
			ps.setInt(5, marks3);
			ps.executeUpdate();
			
			con.setAutoCommit(false);
			String s2="insert into student values(?,?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(s2);
			System.out.println("enter id");
			int id2=sc.nextInt();
			System.out.println("entern the name");
			String name2=sc.next();
			System.out.println("enter marks1");
			int marks12=sc.nextInt();
			System.out.println("enter marks2");
			int marks22=sc.nextInt();
			System.out.println("enter marks3");
			int marks32=sc.nextInt();
			ps1.setInt(1, id2);
			ps1.setString(2, name2);
			ps1.setInt(3, marks12);
			ps1.setInt(4, marks22);
			ps1.setInt(5, marks32);
			ps1.executeUpdate();
			con.commit();
	}
}