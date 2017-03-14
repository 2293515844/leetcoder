package Dao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Target;
import util.JdbcUtils;

public class TargetDao {
	

	
	public static  List<Target> getTargetBytargettype(String targettype)
	{
		List<Target> list=new ArrayList();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql="select * from target where TargetType=?";
			st = conn.prepareStatement(sql);
			st.setObject(1, targettype);
			rs = st.executeQuery();
			
			while(rs.next()){
				Target target=new Target();
				target.setTargetID(rs.getInt(1));
				target.setBoardNo(rs.getString(2));
				target.setTargetType(rs.getString(3));
				target.setTargetCountry(rs.getString(4));
				target.setSonarType(rs.getString(5));
				target.setLastEmergingTime(rs.getLong(6));
				target.setLastEmergingLongitude(rs.getDouble(7));
				target.setLastEmergingLatitude(rs.getDouble(8));
				list.add(target);
			}
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	
	public int getTargetTypePage(String targettype){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from target where TargetType=? ";
			st = conn.prepareStatement(sql);
			st.setString(1, targettype);
			rs = st.executeQuery();
			while(rs.next()){
				
				ret= rs.getInt(1);
			}
			
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return ret;
	}
	
	public List<Target> getTargetTypePage(int startindex,int pagesize,String targettype){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from target  where TargetType=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setString(1, targettype);
			st.setInt(2, startindex);
			st.setInt(3, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Target target=new Target();
				target.setTargetID(rs.getLong(1));
				target.setBoardNo(rs.getString(2));
				target.setTargetType(rs.getString(3));
				target.setTargetCountry(rs.getString(4));
				target.setSonarType(rs.getString(5));
				target.setLastEmergingTime(rs.getLong(6));
				target.setLastEmergingLongitude(rs.getDouble(7));
				target.setLastEmergingLatitude(rs.getDouble(8));
				list.add(target);
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	public int getSonarTypePage(String targettype){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from target where SonarType=? ";
			st = conn.prepareStatement(sql);
			st.setString(1, targettype);
			rs = st.executeQuery();
			while(rs.next()){
				
				ret= rs.getInt(1);
			}
			
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return ret;
	}
	
	public List<Target> getSonarTypePage(int startindex,int pagesize,String targettype){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from target  where SonarType=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setString(1, targettype);
			st.setInt(2, startindex);
			st.setInt(3, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Target target=new Target();
				target.setTargetID(rs.getInt(1));
				target.setBoardNo(rs.getString(2));
				target.setTargetType(rs.getString(3));
				target.setTargetCountry(rs.getString(4));
				target.setSonarType(rs.getString(5));
				target.setLastEmergingTime(rs.getLong(6));
				target.setLastEmergingLongitude(rs.getDouble(7));
				target.setLastEmergingLatitude(rs.getDouble(8));
				list.add(target);
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	//根据 最后一次出现时间查询
	public static  List<Target> getLastemergingtimePage(int startindex,int pagesize,String lastemergingtime)
	{
		List<Target> list=new ArrayList();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql="select * from target where LastEmergingTime=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, lastemergingtime);
			st.setInt(2, startindex);
			st.setInt(3, pagesize);
			rs = st.executeQuery();
			
			while(rs.next()){
				Target target=new Target();
				target.setTargetID(rs.getInt(1));
				target.setBoardNo(rs.getString(2));
				target.setTargetType(rs.getString(3));
				target.setTargetCountry(rs.getString(4));
				target.setSonarType(rs.getString(5));
				target.setLastEmergingTime(rs.getLong(6));
				target.setLastEmergingLongitude(rs.getDouble(7));
				target.setLastEmergingLatitude(rs.getDouble(8));
				list.add(target);
			}
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	
	public int getLastemergingtimesize(String lastemergingtime){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from target where LastEmergingTime=? ";
			st = conn.prepareStatement(sql);
			st.setString(1, lastemergingtime);
			rs = st.executeQuery();
			while(rs.next()){
				
				ret= rs.getInt(1);
			}
			
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return ret;
	}	
	//根据 最后一次出现区域查询
	public static  List<Target> getLastemergingereaPage(int startindex,int pagesize,String lastemergingerea)
	{
		List<Target> list=new ArrayList();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double longitude1=Double.parseDouble(lastemergingerea.split("-")[0]);
		double longitude2=Double.parseDouble(lastemergingerea.split("-")[1]);
		double latitude1=Double.parseDouble(lastemergingerea.split("-")[2]);
		double latitude2=Double.parseDouble(lastemergingerea.split("-")[3]);
		try{
			conn = JdbcUtils.getConnection();
			String sql="select * from target where LastEmergingLongitude>=? and LastEmergingLongitude<=? and LastEmergingLatitude>=? and LastEmergingLatitude<=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, longitude1);
			st.setObject(2, longitude2);
			st.setObject(3, latitude1);
			st.setObject(4, latitude2);
			st.setInt(5, startindex);
			st.setInt(6, pagesize);
			rs = st.executeQuery();
			
			while(rs.next()){
				Target target=new Target();
				target.setTargetID(rs.getInt(1));
				target.setBoardNo(rs.getString(2));
				target.setTargetType(rs.getString(3));
				target.setTargetCountry(rs.getString(4));
				target.setSonarType(rs.getString(5));
				target.setLastEmergingTime(rs.getLong(6));
				target.setLastEmergingLongitude(rs.getDouble(7));
				target.setLastEmergingLatitude(rs.getDouble(8));
				list.add(target);
			}
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	
	public int getLastemergingereasize(String lastemergingerea){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double longitude1=Double.parseDouble(lastemergingerea.split("-")[0]);
		double longitude2=Double.parseDouble(lastemergingerea.split("-")[1]);
		double latitude1=Double.parseDouble(lastemergingerea.split("-")[2]);
		double latitude2=Double.parseDouble(lastemergingerea.split("-")[3]);
		List list = new ArrayList();
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from target where LastEmergingLongitude>=? and LastEmergingLongitude<=? and LastEmergingLatitude>=? and LastEmergingLatitude<=?";
			st = conn.prepareStatement(sql);
			st.setObject(1, longitude1);
			st.setObject(2, longitude2);
			st.setObject(3, latitude1);
			st.setObject(4, latitude2);
			rs = st.executeQuery();
			while(rs.next()){
				
				ret= rs.getInt(1);
			}
			
			
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		return ret;
	}

	public void fin(String s) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from target where "+s;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			File filepass=new File("E:\\cc");
			if(!filepass.exists())
			filepass.mkdirs();
			String filename="2.txt";
			File file=new File(filepass,filename);
			
			file.createNewFile();
			FileWriter fileWriter=new FileWriter(file,true);
			BufferedWriter out=new BufferedWriter(fileWriter);
			String tmp=null;
			while(rs.next()){
				tmp="";
				tmp=tmp+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+"\r\n";
				out.write(tmp);
			}	
			out.flush();
			out.close();
			
		}catch (Exception e) {
			System.out.println(e.toString());
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}			
}
				
				
			
				



