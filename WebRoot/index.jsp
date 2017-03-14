<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <script>
   function checkUser(){
   var result = document.getElementById("input").value;
	var obj   = document.getElementById("select"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var text = obj.options[index].text; // 选中文本
	var value = obj.options[index].value; // 选中值

   if(result == ""  ){
     alert("查询内容不能为空");
     return false;
   }
  else{
   return true;
   }
}
   function checkUser1(){
   var result = document.getElementById("input1").value;
	var obj   = document.getElementById("select1"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var text = obj.options[index].text; // 选中文本
	var value = obj.options[index].value; // 选中值

   if(result == ""  ){
     alert("查询内容不能为空");
     return false;
   }
  else{
   return true;
   }
}
function checkUser2(){
   var result = document.getElementById("input2").value;
	var obj   = document.getElementById("select2"); //定位id
	var index = obj.selectedIndex; // 选中索引
	var text = obj.options[index].text; // 选中文本
	var value = obj.options[index].value; // 选中值

   if(result == ""  ){
     alert("查询内容不能为空");
     return false;
   }
  else{
   return true;
   }
}
</script>
  <body>
  <form id="formid"  name= "myform" method = 'post'  action = 'TargetFind' target="_blank" onsubmit = "return checkUser();" >
    <tr>
                <td width="60" height="40" align="right">目标文件查询&nbsp;</td>
                
    <td>
   <select  id="select" name="select">
  <option value ="targettype">目标类型</option>
  <option value ="sonartype">声呐类型</option>
  <option value="lastemergingtime">最后一次出现时间</option>
  <option value="lastemerginearea">最后一次出现区域</option>
 	</select>
 	
 </td>
 <td><input type="text" value="" class="text2" name = input id = "input"/></td>
   <td width="60" height="40" align="right">&nbsp;</td>
    <td>  <input type="submit" value="确定" class="btn2"  /></td>
   </tr>
</form>
 <form id="formid1"  name= "myform1" method = 'post'  action = 'ArrayFind' target="_blank" onsubmit = "return checkUser1();" >
    <tr>
                <td width="60" height="40" align="right">阵元文件查询&nbsp;</td>
                
    <td>
   <select  id="select1" name="select1">
  <option value ="recordstarttime">开始记录时间区间</option>
  <option value ="deviceID">设备ID</option>
  <option value="erea">出现区域</option>
  
 	</select>
 	
 </td>
 <td><input type="text" value="" class="text2" name = input1 id = "input1"/></td>
   <td width="60" height="40" align="right">&nbsp;</td>
    <td>  <input type="submit" value="确定" class="btn2"  /></td>
   </tr>
</form>
<form id="formid2"  name= "myform2" method = 'post'  action = 'SampleFind' target="_blank" onsubmit = "return checkUser2();" >
    <tr>
                <td width="60" height="40" align="right">样本数据查询&nbsp;</td>
                
    <td>
   <select  id="select2" name="select2">
  <option value ="timelimit">时间区间</option>
  
 	</select>
 	
 </td>
 <td><input type="text" value="" class="text2" name = input2 id = "input2"/></td>
   <td width="60" height="40" align="right">&nbsp;</td>
    <td>  <input type="submit" value="确定" class="btn2"  /></td>
   </tr>
</form>
  </body>
</html>
