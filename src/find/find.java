package find;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Dao.ArrayDao;
import Dao.SampleDao;
import Dao.TargetDao;

public class find {

	public static void main(String[] args) {
		File filepass;
		String pass = "E:\\bb";
		while(true){
		try {
			filepass= new File(pass);
			 File files[]=filepass.listFiles();
			 for(File file:files)
			 {
				 if(file.exists()&&file.isFile())
				 {
					
					 int fileclassify;
					 fileclassify=Integer.parseInt(file.getName().substring(0, 1));
					 if(fileclassify==4)//阵元数据文件查询
					 {
						 FileReader read=new FileReader(file);
						BufferedReader br=new BufferedReader(read);
						int count=0;
						count=Integer.parseInt(br.readLine());
						String names[]=new String[count];
						String values[]=new String[count];
						names=br.readLine().split(" ");
						values=br.readLine().split(" ");
						String tmp="";
						for(int i=0;i<count;i++)
						{
							tmp=tmp+names[i]+"="+values[i]+" and ";
						}
						tmp=tmp.substring(0, tmp.length()-5);
						ArrayDao arrayDao=new ArrayDao();
						arrayDao.fin(tmp);
						 br.close();
						 read.close();
					 }
					 else
					 if(fileclassify==5)//目标文件查询
					 {
						 FileReader read=new FileReader(file);
							BufferedReader br=new BufferedReader(read);
							int count=0;
							count=Integer.parseInt(br.readLine());
							String names[]=new String[count];
							String values[]=new String[count];
							names=br.readLine().split(" ");
							values=br.readLine().split(" ");
							String tmp="";
							for(int i=0;i<count;i++)
							{
								tmp=tmp+names[i]+"="+values[i]+" and ";
							}
							tmp=tmp.substring(0, tmp.length()-5);
							TargetDao targetDao=new TargetDao();
							targetDao.fin(tmp);
							 br.close();
							 read.close();
					 }
					else
					if(fileclassify==6)//目标文件查询
					{
						FileReader read=new FileReader(file);
						BufferedReader br=new BufferedReader(read);
						int count=0;
						count=Integer.parseInt(br.readLine());
						String names[]=new String[count];
						String values[]=new String[count];
						names=br.readLine().split(" ");
						values=br.readLine().split(" ");
						String tmp="";
						for(int i=0;i<count;i++)
						{
							tmp=tmp+names[i]+"="+values[i]+" and ";
						}
						tmp=tmp.substring(0, tmp.length()-5);
						SampleDao sampleDao=new SampleDao();
						sampleDao.fin(tmp);
						 br.close();
						 read.close();		 
					}
					// file.delete();
				 }
			 }
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
