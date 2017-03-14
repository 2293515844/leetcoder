package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListSonarTypeService {

TargetDao targetDao= new TargetDao();
	public Page getSonarTypePageData(String pagenum,String url,String sonartype){
		int totalrecord = targetDao.getSonarTypePage(sonartype);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = targetDao.getSonarTypePage(page.getStartindex(), page.getPagesize(),sonartype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getSonarTypePage(page.getStartindex(), page.getPagesize(),sonartype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
