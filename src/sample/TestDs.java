package sample;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDs {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try 
		{
			con =DBUtil.getConnection();
			st = con.createStatement();
			
			rs = st.executeQuery("select now()");
			
			System.out.println(rs.next());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
			
			try 
			{
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
