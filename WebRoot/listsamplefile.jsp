<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.AttributeDao" %>
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
    
    <title>样本数据文件信息</title>
    
	<meta http-equiv="pragma" content="no-cache">

  </head>
  
  <body>
    <table width="90%" frame="border">
    <tr>
    	
    	<td>样本数据文件名</td>
    	<td>样本数据文件生成时间</td>
    	<td>阵元数据文件名</td>
    	<td>目标编号</td>
    	<td>样本数据特征</td>
    </tr>
    	 	<c:forEach var="samplefile" items="${page.list}">
    		<tr>
    			<td>${samplefile.sampleFileName} </td>
    			<td>${samplefile.smpleFileRecordTime} </td>
    			<td>${samplefile.arrayDataFilename} </td>
    			<td>${samplefile.targetID} </td>
    			<td><a href="Attributes?SampleFileName=${samplefile.sampleFileName}">查看属性</a> </td>
    			
    		</tr>
    	</c:forEach>
    </table>
    <%@include file="/page.jsp" %>
  </body>
</html>
