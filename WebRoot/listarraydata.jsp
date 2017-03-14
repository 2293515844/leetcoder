<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>阵元数据信息</title>
    
	<meta http-equiv="pragma" content="no-cache">

  </head>
  
  <body>
    <table width="90%" frame="border">
    <tr>
    	
    	<td>阵元数据文件名</td>
    	<td>设备ID号</td>
    	<td>开始记录时间</td>
    	<td>本船经度</td>
    	<td>本船纬度</td>
    </tr>
    	 	<c:forEach var="arraydata" items="${page.list}">
    		<tr>
    			
    			<td>${arraydata.arrayDataFileName} </td>
    			<td>${arraydata.deviceID} </td>
    			<td>${arraydata.recordStartTime} </td>
    			<td>${arraydata.longitude} </td>
    			<td>${arraydata.latitude} </td>
    		</tr>
    	</c:forEach>
    </table>
    <%@include file="/page.jsp" %>
  </body>
</html>
