package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListLastEmergingEreaService {

TargetDao targetDao= new TargetDao();
	public Page getLastemergingereaPageData(String pagenum,String url,String lastemergingerea){
		int totalrecord = targetDao.getLastemergingereasize(lastemergingerea);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = targetDao.getLastemergingereaPage(page.getStartindex(), page.getPagesize(), lastemergingerea);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getLastemergingereaPage(page.getStartindex(), page.getPagesize(),lastemergingerea);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
