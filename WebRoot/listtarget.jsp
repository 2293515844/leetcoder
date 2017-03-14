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
    
    <title>My JSP 'downtarget.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">

  </head>
  
  <body>
    <table width="90%" frame="border">
    <tr>
    	<td>目标编号</td>
    	<td>目标舷号</td>
    	<td>目标类型</td>
    	<td>目标国别</td>
    	<td>声呐类型</td>
    	<td>最后一次出现时间</td>
    	<td>最后一次出现经度</td>
    	<td>最后一次出现纬度</td>
    </tr>
    	 	<c:forEach var="target" items="${page.list}">
    		<tr>
    			<td>${target.targetID} </td>
    			<td>${target.boardNo} </td>
    			<td>${target.targetType} </td>
    			<td>${target.targetCountry} </td>
    			<td>${target.sonarType} </td>
    			<td>${target.lastEmergingTime} </td>
    			<td>${target.lastEmergingLongitude} </td>
    			<td>${target.lastEmergingLatitude} </td>
    		</tr>
    	</c:forEach>
    </table>
    <%@include file="/page.jsp" %>
  </body>
</html>
