package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static{
		try{
			 String driver="com.mysql.jdbc.Driver";
			  url = "jdbc:mysql://127.0.0.1:3306/my";//sa身份连接   
			 Connection con = null;   
			  username = "root";// 数据库用户登陆名 

			  password = "";// 密码
			
			Class.forName(driver);
			
		}catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){
		
		
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;

		}
		if(st!=null){
			try{
				st.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
