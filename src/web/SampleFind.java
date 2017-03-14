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
import service.ListSmpleFileRecordTimeService;
import service.ListSonarTypeService;
import service.ListTargetTypeService;
import bean.ArrayData;
import bean.Page;
import bean.Target;
import Dao.SampleDao;
import Dao.TargetDao;
public class SampleFind extends HttpServlet {
	public SampleFind() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("select2");
		String input=request.getParameter("input2");
		if(type==null)
			type=(String) request.getSession().getAttribute("select2");
		if(input==null)
			input=(String) request.getSession().getAttribute("input2");
		request.getSession().setAttribute("select2", type);
		request.getSession().setAttribute("input2", input);
		System.out.println(type);
		System.out.println(input);
		
		SampleDao sampleDao=new SampleDao();
		 try{
			 if(type.equals("timelimit"))
				{
					String pagenum = request.getParameter("pagenum");
					ListSmpleFileRecordTimeService service = new ListSmpleFileRecordTimeService();
					String serletName = this.getServletName();
					Page page = service.getRecordTimePageData(pagenum, request.getContextPath() + "/" + serletName, input);
					request.getSession().setAttribute("page", page);
					//System.out.println(page.getList().size());
					request.getRequestDispatcher("/listsamplefile.jsp").forward(request, response);
					return ;
				}
			 if(type.equals("deviceID"))
				{
					
					String pagenum = request.getParameter("pagenum");
					ListDeviceIDService service = new ListDeviceIDService();
					String serletName = this.getServletName();
					Page page = service.getDeviceIDPageData(pagenum, request.getContextPath() + "/" + serletName, input);
					request.getSession().setAttribute("page", page);
					//System.out.println(page.getList().size());
					request.getRequestDispatcher("/listarraydata.jsp").forward(request, response);
					return ;
				}
			 if(type.equals("erea"))
				{
					
					String pagenum = request.getParameter("pagenum");
					ListEreaService service = new ListEreaService();
					String serletName = this.getServletName();
					Page page = service.getEreaPageData(pagenum, request.getContextPath() + "/" + serletName, input);
					request.getSession().setAttribute("page", page);
					//System.out.println(page.getList().size());
					request.getRequestDispatcher("/listarraydata.jsp").forward(request, response);
					return ;
				}
		
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
