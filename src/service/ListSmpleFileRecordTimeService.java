package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;
import Dao.SampleDao;


public class ListSmpleFileRecordTimeService {

SampleDao sampleDao= new SampleDao();
	public Page getRecordTimePageData(String pagenum,String url,String smpleFileRecordTime){
		int totalrecord = sampleDao.getSmpleFileRecordTime(smpleFileRecordTime);
		if(pagenum==null){
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord,1);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			List list = sampleDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(), smpleFileRecordTime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = sampleDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(),smpleFileRecordTime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
