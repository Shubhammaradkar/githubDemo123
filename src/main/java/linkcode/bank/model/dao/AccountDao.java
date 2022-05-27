package linkcode.bank.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import linkcode.bank.model.Account;
import linkcode.bank.model.Login;

public class AccountDao {
	

	public int saveData(Account acc)
	{
		Connection con=MyConnection.getConnection();
		System.out.println("conn: "+con);
		try {
			PreparedStatement ps=con.prepareStatement("insert into linkcode values(?,?,?,?,?)");
			ps.setInt(1, acc.getAccno());
			ps.setString(2, acc.getCname());
			ps.setString(3, acc.getUname());
			ps.setString(4, acc.getPass());
			ps.setInt(5, acc.getAccbal());
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Record Saved...!");
			}
			else
			{
				System.out.println("Record not Saved...!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean LoginData(Login lobj) {
		boolean b=false;
		Connection con=MyConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from linkcode where uname=? and pass=?");
			ps.setString(1, lobj.getUname());
			ps.setString(2, lobj.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return b;
	}
	
	public void searchData() {
		
		Connection con=MyConnection.getConnection();

		PreparedStatement ps=con.prepareStatement("select * from linkcode where uname=? and pass=?");
		
		ps.setString(1, lobj.getUname()); 
		ps.setString(2, lobj.getPass());
	}
}

