package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;
import bean.SampleFile;

public class AttributeDao {
	public List<String> getAttributes(String SampleFilename){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<String> list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select Attribute from  attributes where SampleFileName=? ";
			st = conn.prepareStatement(sql);
			st.setObject(1, SampleFilename);
			rs = st.executeQuery();
			while(rs.next()){
				
				list.add(rs.getString(1));
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}

	public String find(String SampleFilename) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String ret="";
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from  attributes where SampleFileName=? ";
			st = conn.prepareStatement(sql);
			st.setObject(1, SampleFilename);
			rs = st.executeQuery();
			while(rs.next()){
				ret=ret+rs.getString(3)+" ";
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return ret.substring(0, ret.length()-1);
		
	}
	
}
