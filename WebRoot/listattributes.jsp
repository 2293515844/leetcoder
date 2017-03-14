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
    
    <title>属性特征</title>
    
	<meta http-equiv="pragma" content="no-cache">

  </head>
  
  <body>
    <table width="90%" frame="border">
    <tr>
    	
    	<c:forEach var="attribute"  items="${attribute}" varStatus="status">
    		
    			${attribute}
    			<c:if test="${status.count%5==0}"><br/></c:if>
    			
    			
    			
    	</c:forEach>
    </tr>
    	 	
    </table>
   
  </body>
</html>
