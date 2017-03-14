package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Dao.ArrayDao;
import Dao.SampleDao;
import Dao.TargetDao;
public class Test {
	public static void main(String[]args)
	{
		ArrayDao arrayDao=new ArrayDao();
		arrayDao.fin("DeviceID=1 and RecordStartTime=1487812826");
		SampleDao sampleDao=new SampleDao();
		sampleDao.fin("TargetID=20");
	}

}
