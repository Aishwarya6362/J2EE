import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pgm6example1 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("1.register");
		System.out.println("2.login");
		System.out.println("3.change password");
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:register();
		break;
		
		case 2:login();
		break;
		
		case 3:ChangePassword();
		break;
		
		default:System.out.println("invalid choice");
		break;
		}
	}

	static void ChangePassword() throws SQLException {
		Connection con=Driver.getConnection();
		
		System.out.println("enter username: ");
		String user_name=sc.next();
		
		System.out.println("enter  new password: ");
		String pwd=sc.next();
		
		String s="update user set passwordd=? where user_name=? ";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1,pwd);
		ps.setString(2, user_name);
		int rows=ps.executeUpdate();
		System.out.println("successfully updated password");
	}

	static void register() throws Exception {
		Connection con=Driver.getConnection();
		
		System.out.println("enter name: ");
		String namee=sc.next();
		
		System.out.println("enter username: ");
		String user_name=sc.next();
		
		while(true) {
			String s="select * from user where user_name=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1,user_name);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				System.out.println("username already exists");
				user_name=sc.next();
			}
			else {
				break;
			}
		}
		String passwordd;
		String cp;
		do {
		System.out.println("enter password");
		passwordd=sc.next();
		System.out.println("confirm password");
		cp=sc.next();	
		} while(!passwordd.equals(cp));
		
		System.out.println("enter email: ");
		String email=sc.next();
			
			String s1="insert into user values(?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(s1);
			pstmt1.setString(1,namee);
			pstmt1.setString(2, user_name);
			pstmt1.setString(3, passwordd);
			pstmt1.setString(4, email);
	}
	
	 static void login()throws Exception{
			Connection con=Driver.getConnection();
			System.out.println("enter the username: ");
			String user_name=sc.next();
			System.out.println("enter password: ");
			String passwordd=sc.next();
			String s="select * from user where user_name=?";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1, user_name);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				if(passwordd.equals(res.getString(3))) {
					System.out.println("login successfully");
				}
				else {
					System.out.println("invalid password");
				}
			}
			else {
				System.out.println("invalid username.");
			}
//			String s="select * from user where user_name=? and passwordd=?";
//			PreparedStatement pstmt=con.prepareStatement(s);//give value here.
//			pstmt.setString(1,user_name);
//			pstmt.setString(2, passwordd);
//			ResultSet res=pstmt.executeQuery();
//			if(res.next()) {
//				System.out.println("successfully logged in");
//				break;
//			}
//			else {
//				System.out.println("failed");
//			}
		}						
	}