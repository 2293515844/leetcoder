package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;


public class ListDeviceIDService {

ArrayDao arrayDao= new ArrayDao();
	public Page getDeviceIDPageData(String pagenum,String url,String deviceID){
		int totalrecord = arrayDao.getDeviceID(deviceID);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = arrayDao.getDeviceIDPage(page.getStartindex(), page.getPagesize(), deviceID);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = arrayDao.getDeviceIDPage(page.getStartindex(), page.getPagesize(),deviceID);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
