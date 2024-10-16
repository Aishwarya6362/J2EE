import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;


public class YCrud {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msproject1","root","123456789");
		
//		retrieving the data from table
		String s="select * from student;";
		Statement st=con.createStatement();
		Resultset res=(Resultset) st.executeQuery(s);
		while(((ResultSet) res).next()==true) {
			int id=((ResultSet) res).getInt(1);
			String name=((ResultSet) res).getString(2);
			int marks1=((ResultSet) res).getInt(3);
			int marks2=((ResultSet) res).getInt(4);
			int marks3=((ResultSet) res).getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);

			//inserting the values into the table
			Scanner sc=new Scanner(System.in);
			String s1="insert into student values(?,?,?,?,?);";
			PreparedStatement ps1=con.prepareStatement(s1);
			System.out.println("enter id");
			int id1=sc.nextInt();
			System.out.println("enter name");
			String name1=sc.next();
			System.out.println("enter marks1");
			int marks11=sc.nextInt();
			System.out.println("enter marks2");
			int marks21=sc.nextInt();
			System.out.println("enter marks3");
			int marks31=sc.nextInt();
			
			ps1.setInt(1,id1);
			ps1.setString(2, name1);
			ps1.setInt(3, marks11);
			ps1.setInt(4, marks21);
			ps1.setInt(5, marks31);
			int rows1=ps1.executeUpdate();
			System.out.println(rows1);
			
			//update the values into table
			String s2="update student set name=? where id=?;";
			PreparedStatement ps2=con.prepareStatement(s2);
			System.out.println("enter name");
			String name2=sc.next();
			System.out.println("enter id");
			int id2=sc.nextInt();
			ps2.setString(1, name2);
			ps2.setInt(2, id2);
			int rows2=ps2.executeUpdate();
			System.out.println(rows2);
			
			//deleting 
			String s3="delete from student where id=?;";
			PreparedStatement ps3=con.prepareStatement(s3);
			System.out.println("enter id");
			int id3=sc.nextInt();
			ps2.setInt(2, id3);
			int rows3=ps3.executeUpdate();
			System.out.println(rows3);
			
		}
	}
}
