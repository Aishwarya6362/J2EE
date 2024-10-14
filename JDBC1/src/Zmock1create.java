import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class Zmock1create {
	public static void main(String[] args) throws Exception {
		Connection con=Driver.getConnection();
		String s="select * from employee";
		Statement stmt=con.createStatement();
		ResultSet res=stmt.executeQuery(s);
		ResultSetMetaData rsmd=(ResultSetMetaData) res.getMetaData();
		for(int i=1;i<=rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnTypeName(i));
		}
		while(res.next()==true) {
				int emp_id=res.getInt(1);
				String emp_name=res.getString(2);
				String place=res.getString(3);
				System.out.println(emp_id+" "+emp_name+" "+place);
		}
	}
}