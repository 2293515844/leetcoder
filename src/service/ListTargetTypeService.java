package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListTargetTypeService {

TargetDao targetDao= new TargetDao();
	public Page getTargetTypePageData(String pagenum,String url,String targettype){
		int totalrecord = targetDao.getTargetTypePage(targettype);
		if(pagenum==null){
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord,1);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			List list = targetDao.getTargetTypePage(page.getStartindex(), page.getPagesize(),targettype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getTargetTypePage(page.getStartindex(), page.getPagesize(),targettype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
