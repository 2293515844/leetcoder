package web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ListDeviceIDService;
import service.ListEreaService;
import service.ListLastEmergingEreaService;
import service.ListLastEmergingTimeService;
import service.ListRecordStartTimeService;
import service.ListSonarTypeService;
import service.ListTargetTypeService;
import bean.ArrayData;
import bean.Page;
import bean.Target;
import Dao.AttributeDao;
import Dao.TargetDao;
public class Attributes extends HttpServlet {
	public Attributes() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String SampleFileName=request.getParameter("SampleFileName");
		
		System.out.println(SampleFileName);
		AttributeDao attributeDao=new AttributeDao();
		List<String> list=attributeDao.getAttributes(SampleFileName);
		request.getSession().setAttribute("attribute",list );
		//System.out.println(page.getList().size());
		request.getRequestDispatcher("/listattributes.jsp").forward(request, response);
		 try{
			 
			 
		 }catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "≤È—Ø ß∞‹£°£°£°");
				
				
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	public void init() throws ServletException {

	}

}
