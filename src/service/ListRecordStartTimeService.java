package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;

public class ListRecordStartTimeService {

ArrayDao arrayDao= new ArrayDao();
	public Page getRecordStartTimePageData(String pagenum,String url,String recordstarttime){
		int totalrecord = arrayDao.getRecordStartTime(recordstarttime);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = arrayDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(), recordstarttime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = arrayDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(),recordstarttime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
