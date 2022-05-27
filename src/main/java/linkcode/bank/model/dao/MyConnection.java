package linkcode.bank.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	
	
	
	public static Connection getConnection() {
		{
			Connection con=null;
			
				try {
					System.out.println("in conn class");
					Class.forName("oracle.jdbc.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(con);
			
			System.out.println("Connection :"+con);
			return con;
		}
	}
}
