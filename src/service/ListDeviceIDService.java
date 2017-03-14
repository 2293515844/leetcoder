package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;


public class ListDeviceIDService {

ArrayDao arrayDao= new ArrayDao();
	public Page getDeviceIDPageData(String pagenum,String url,String deviceID){
		int totalrecord = arrayDao.getDeviceID(deviceID);
		if(pagenum==null){
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord,1);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			List list = arrayDao.getDeviceIDPage(page.getStartindex(), page.getPagesize(), deviceID);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = arrayDao.getDeviceIDPage(page.getStartindex(), page.getPagesize(),deviceID);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
