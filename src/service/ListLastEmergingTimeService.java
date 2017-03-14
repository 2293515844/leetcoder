package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListLastEmergingTimeService {

TargetDao targetDao= new TargetDao();
	public Page getLastemergingtimePageData(String pagenum,String url,String lastemergingtime){
		int totalrecord = targetDao.getLastemergingtimesize(lastemergingtime);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = targetDao.getLastemergingtimePage(page.getStartindex(), page.getPagesize(), lastemergingtime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getLastemergingtimePage(page.getStartindex(), page.getPagesize(),lastemergingtime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
