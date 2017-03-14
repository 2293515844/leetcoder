package web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ListLastEmergingEreaService;
import service.ListLastEmergingTimeService;
import service.ListSonarTypeService;
import service.ListTargetTypeService;
import bean.Page;
import bean.Target;
import Dao.TargetDao;
public class TargetFind extends HttpServlet {
	public TargetFind() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("select");
		String input=request.getParameter("input");
		if(type==null)
			type=(String) request.getSession().getAttribute("select");
		if(input==null)
			input=(String) request.getSession().getAttribute("input");
		request.getSession().setAttribute("select", type);
		request.getSession().setAttribute("input", input);
		System.out.println(type);
		
		 try{
		if(type.equals("targettype"))
		{
			
			String pagenum = request.getParameter("pagenum");
			ListTargetTypeService service = new ListTargetTypeService();
			String serletName = this.getServletName();
			Page page = service.getTargetTypePageData(pagenum, request.getContextPath() + "/" + serletName, input);
			request.getSession().setAttribute("page", page);
			//System.out.println(page.getList().size());
			request.getRequestDispatcher("/listtarget.jsp").forward(request, response);
			return ;
		}
		if(type.equals("sonartype"))
		{
			
			String pagenum = request.getParameter("pagenum");
			ListSonarTypeService service = new ListSonarTypeService();
			String serletName = this.getServletName();
			Page page = service.getSonarTypePageData(pagenum, request.getContextPath() + "/" + serletName, input);
			request.getSession().setAttribute("page", page);
			//System.out.println(page.getList().size());
			request.getRequestDispatcher("/listtarget.jsp").forward(request, response);
			return ;
		}
		if(type.equals("lastemergingtime"))
		{
			
			String pagenum = request.getParameter("pagenum");
			ListLastEmergingTimeService service = new ListLastEmergingTimeService();
			String serletName = this.getServletName();
			Page page = service.getLastemergingtimePageData(pagenum, request.getContextPath() + "/" + serletName, input);
			request.getSession().setAttribute("page", page);
			//System.out.println(page.getList().size());
			request.getRequestDispatcher("/listtarget.jsp").forward(request, response);
			return ;
		}
		if(type.equals("lastemerginearea"))
		{
			
			String pagenum = request.getParameter("pagenum");
			ListLastEmergingEreaService service = new ListLastEmergingEreaService();
			String serletName = this.getServletName();
			Page page = service.getLastemergingereaPageData(pagenum, request.getContextPath() + "/" + serletName, input);
			request.getSession().setAttribute("page", page);
			//System.out.println(page.getList().size());
			request.getRequestDispatcher("/listtarget.jsp").forward(request, response);
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
