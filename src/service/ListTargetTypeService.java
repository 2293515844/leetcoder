package service;

import java.util.List;

import bean.Page;
import Dao.TargetDao;

public class ListTargetTypeService {

TargetDao targetDao= new TargetDao();
	public Page getTargetTypePageData(String pagenum,String url,String targettype){
		int totalrecord = targetDao.getTargetTypePage(targettype);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = targetDao.getTargetTypePage(page.getStartindex(), page.getPagesize(),targettype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = targetDao.getTargetTypePage(page.getStartindex(), page.getPagesize(),targettype);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
