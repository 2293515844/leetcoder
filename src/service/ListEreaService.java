package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;


public class ListEreaService {

ArrayDao arrayDao= new ArrayDao();
	public Page getEreaPageData(String pagenum,String url,String erea){
		int totalrecord = arrayDao.getErea(erea);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = arrayDao.getEreaPage(page.getStartindex(), page.getPagesize(), erea);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = arrayDao.getEreaPage(page.getStartindex(), page.getPagesize(),erea);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
