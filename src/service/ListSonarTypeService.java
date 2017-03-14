package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListSonarTypeService {

TargetDao targetDao= new TargetDao();
	public Page getSonarTypePageData(String pagenum,String url,String sonartype){
		int totalrecord = targetDao.getSonarTypePage(sonartype);
		if(pagenum==null){
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord,1);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			List list = targetDao.getSonarTypePage(page.getStartindex(), page.getPagesize(),sonartype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getSonarTypePage(page.getStartindex(), page.getPagesize(),sonartype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
