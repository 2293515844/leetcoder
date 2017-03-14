package service;

import java.util.List;

import bean.Page;
import Dao.ArrayDao;
import Dao.SampleDao;


public class ListSmpleFileRecordTimeService {

SampleDao sampleDao= new SampleDao();
	public Page getRecordTimePageData(String pagenum,String url,String smpleFileRecordTime){
		int totalrecord = sampleDao.getSmpleFileRecordTime(smpleFileRecordTime);
		if(pagenum==null){
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = sampleDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(), smpleFileRecordTime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = sampleDao.getRecordStartTimePage(page.getStartindex(), page.getPagesize(),smpleFileRecordTime);
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

}
