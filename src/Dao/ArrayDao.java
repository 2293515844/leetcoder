package Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;
import bean.ArrayData;
import bean.Target;

public class ArrayDao {
	public int getRecordStartTime(String recordstarttime){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Long time1=Long.parseLong(recordstarttime.split("-")[0]);
		Long time2=Long.parseLong(recordstarttime.split("-")[1]);
		System.out.println(time1+"   "+time2);
	
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from arraydata where RecordStartTime>=? and RecordStartTime<=?";
			st = conn.prepareStatement(sql);
			st.setObject(1, time1);
			st.setObject(2, time2);
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
	
	public List<ArrayData> getRecordStartTimePage(int startindex,int pagesize,String recordstarttime){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Long time1=Long.parseLong(recordstarttime.split("-")[0]);
		Long time2=Long.parseLong(recordstarttime.split("-")[1]);
		List<ArrayData> list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from arraydata  where RecordStartTime>=? and RecordStartTime<=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, time1);
			st.setObject(2, time2);
			st.setInt(3, startindex);
			st.setInt(4, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				ArrayData arraydata=new ArrayData();
				
				arraydata.setArrayDataFileName(rs.getString(1));
				arraydata.setDeviceID(rs.getLong(2));
				arraydata.setRecordStartTime(rs.getLong(3));
				arraydata.setLongitude(rs.getDouble(4));
				arraydata.setLatitude(rs.getDouble(5));
				list.add(arraydata);
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	public int getDeviceID(String deviceID){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from arraydata where DeviceID=?";
			st = conn.prepareStatement(sql);
			st.setObject(1, deviceID);
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
	//根据设备ID查询
	public List<ArrayData> getDeviceIDPage(int startindex,int pagesize,String deviceID){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<ArrayData> list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from arraydata  where DeviceID=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, deviceID);
			st.setInt(2, startindex);
			st.setInt(3, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				ArrayData arraydata=new ArrayData();
				arraydata.setArrayDataFileName(rs.getString(1));
				arraydata.setDeviceID(rs.getLong(2));
				arraydata.setRecordStartTime(rs.getLong(3));
				arraydata.setLongitude(rs.getDouble(4));
				arraydata.setLatitude(rs.getDouble(5));
				list.add(arraydata);
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	//根据船出现的经纬度范围查询
	public static  List<ArrayData> getEreaPage(int startindex,int pagesize,String erea)
	{
		List<ArrayData> list=new ArrayList();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double longitude1=Double.parseDouble(erea.split("-")[0]);
		double longitude2=Double.parseDouble(erea.split("-")[1]);
		double latitude1=Double.parseDouble(erea.split("-")[2]);
		double latitude2=Double.parseDouble(erea.split("-")[3]);
		try{
			conn = JdbcUtils.getConnection();
			String sql="select * from arraydata where Longitude>=? and Longitude<=? and Latitude>=? and Latitude<=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, longitude1);
			st.setObject(2, longitude2);
			st.setObject(3, latitude1);
			st.setObject(4, latitude2);
			st.setInt(5, startindex);
			st.setInt(6, pagesize);
			rs = st.executeQuery();
			
			while(rs.next()){
				ArrayData arraydata=new ArrayData();
				arraydata.setArrayDataFileName(rs.getString(1));
				arraydata.setDeviceID(rs.getLong(2));
				arraydata.setRecordStartTime(rs.getLong(3));
				arraydata.setLongitude(rs.getDouble(4));
				arraydata.setLatitude(rs.getDouble(5));
				list.add(arraydata);
			}
			
		}catch (Exception e) {
			System.out.println(e.toString());
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}
	
	public int getErea(String erea){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		double longitude1=Double.parseDouble(erea.split("-")[0]);
		double longitude2=Double.parseDouble(erea.split("-")[1]);
		double latitude1=Double.parseDouble(erea.split("-")[2]);
		double latitude2=Double.parseDouble(erea.split("-")[3]);
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from arraydata where Longitude>=? and Longitude<=? and Latitude>=? and Latitude<=?";
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
			String sql = "select * from arraydata where "+s;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			File filepass=new File("E:\\cc");
			if(!filepass.exists())
			filepass.mkdirs();
			String filename="1.txt";
			File file=new File(filepass,filename);
			file.createNewFile();
			FileWriter fileWriter=new FileWriter(file,true);
			BufferedWriter out=new BufferedWriter(fileWriter);
			String tmp=null;
			while(rs.next()){
				tmp="";
				tmp=tmp+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+"\r\n";
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
