import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver{
	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usern","root","123456789");
		return con;
	}	
}
