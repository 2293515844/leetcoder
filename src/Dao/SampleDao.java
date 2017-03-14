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
import bean.SampleFile;

public class SampleDao {
	//根据记录时间区间查询
	public int getSmpleFileRecordTime(String smpleFileRecordTime){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Long time1=Long.parseLong(smpleFileRecordTime.split("-")[0]);
		Long time2=Long.parseLong(smpleFileRecordTime.split("-")[1]);
		System.out.println(time1+"   "+time2);
	
		int ret=0;
		try{
			conn = JdbcUtils.getConnection();
			String sql = " select count(*) from samplefile where SmpleFileRecordTime>=? and SmpleFileRecordTime<=?";
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
	
	public List<SampleFile> getRecordStartTimePage(int startindex,int pagesize,String smpleFileRecordTime){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Long time1=Long.parseLong(smpleFileRecordTime.split("-")[0]);
		Long time2=Long.parseLong(smpleFileRecordTime.split("-")[1]);
		List<SampleFile> list = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from  samplefile where SmpleFileRecordTime>=? and SmpleFileRecordTime<=? LIMIT ?,?";
			st = conn.prepareStatement(sql);
			st.setObject(1, time1);
			st.setObject(2, time2);
			st.setInt(3, startindex);
			st.setInt(4, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				SampleFile sampleFile=new SampleFile();
				sampleFile.setSampleFileName(rs.getString(1));
				sampleFile.setSmpleFileRecordTime(rs.getLong(2));
				sampleFile.setArrayDataFilename(rs.getString(3));
				sampleFile.setTargetID(rs.getLong(4));
				list.add(sampleFile);
			}
		}catch (Exception e) {
			
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
		return list;
	}

	public void fin(String s) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from samplefile where "+s;
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			File filepass=new File("E:\\cc");
			if(!filepass.exists())
			filepass.mkdirs();
			String filename="3.txt";
			File file=new File(filepass,filename);
			file.createNewFile();
			FileWriter fileWriter=new FileWriter(file,true);
			BufferedWriter out=new BufferedWriter(fileWriter);
			String tmp=null;
			while(rs.next()){
				tmp="";
				AttributeDao attributeDao=new AttributeDao();
				tmp=tmp+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+attributeDao.find(rs.getString(1))+"\r\n";
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
