<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.iweb.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>${msg}我是JSP[JSTL-EL-读取pageScope,request, session里存储的对象]</title>
<link rel="stylesheet" href="../css/table.css">
<script src="../js/jquery-1.3.2.min.js"></script>
<script src="../js/calendar.js"></script>
<script src="../js/list-user.js"></script>
<link rel="stylesheet" type="text/css" href="../css/easyui.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script>
	if('${sessionScope.msg}'){
		//alert('${fn:length(users)}');		
	}
</script>
</head>
<body>
	<!-- 这个普通用户是能看到的 -->
	<%-- 这个是普通用户看不到的 --%>
	<%--set是往pageContext对象中存储信息,生命周期在一个页面的{}内 --%>
	
	<div class="easyui-layout" style="width:100%;height:760px;">
		<div data-options="region:'north'" style="height:50px">
		<c:set var="className" value="fail"/>
		<c:if test="${msg=='删除成功！'}">
		<c:set var="className" value="success"/>
		</c:if>
		
		<c:if test="${!empty msg}">
		<div id="msg" class="${className}">${msg}</div>
		</c:if>
		<p style="float:left">
		<script type="text/javascript" >
		
			today=new Date();
			var day;
			var data;
			if(today.getDay()==0) day="星期日";
			if(today.getDay()==1) day="星期一";
			if(today.getDay()==2) day="星期二";
			if(today.getDay()==3) day="星期三";
			if(today.getDay()==4) day="星期四";
			if(today.getDay()==5) day="星期五";
			if(today.getDay()==6) day="星期六";
			data=(today.getYear()+1900)+"年"+(today.getMonth()+1)+"月"+(today.getDate()+"日");
			document.write(data);
			document.write("&nbsp");
			document.write(day);
		
			
		</script>
		欢迎您！
		</p>
		<h3 style="text-align:center">总共${fn:length(grades)}位用户,每位用户一张成绩单</h3>
		</div>
		<div data-options="region:'south',split:true" style="height:50px; text-align:center">
		Copyright © 2013-2018 洪鹏程  onlinetest.com All Rights Reserved. 
		</div>
		<div data-options="region:'east',split:true" title="East" style="width:200px;"><!-- 右栏 -->
			<h4 style="text-align:center; padding: 20px; margin: 0 0;background-color: #E0ECFF;">发送邮件</h4>
			<form action="sendMailServlet" method="post">
			    <table align="center" border="2" cellspacing="1" cellpadding="1" width="100">
			    <tr>
	    			<td>收件人
	    			<input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	    		</tr>
			    <tr>
				    <td width="50%">
				    邮箱<br><input class="easyui-textbox" required name="to" size="20">
				    </td>   
			    </tr>
			    <tr>
				    <td colspan="2">
				    主题<br><input class="easyui-textbox" name="title" size="20">
				    </td>
			    </tr>
			    <tr>
				    <td colspan="5">
				    <p>内容<br><input class="easyui-textbox" name="content" data-options="multiline:true" style="height:60px;width:200px"></input></p>
				    </td>
			    </tr>
			    <tr>
			      <td colspan="2">
			       <input class="easyui-linkbutton" type="submit" name="send" value="发送">
			       <input class="easyui-linkbutton" type="reset" name="reset" value="重置">
			      </td>
			    </tr>
			    </table>   
		    </form>
			
		</div>
		<div data-options="region:'west',split:true" title="West" style="width:200px;"><!-- 左栏 -->
		<h4 style="text-align:center; padding: 20px; margin: 0 0;background-color: #E0ECFF;">综合查询区域</h4>
		<form action="/testweb/user/serachServlet?flag=grade" method="post">
			<span style="font-size:14px">及格线：</span>
			<input class="easyui-textbox" id="key" type="text" name="key" style="width:120px">
			<br>
			<br>
			<span style="font-size:14px">选条件：</span>
			<select class="easyui-combobox" id="selected" name="select" style="width:120px">
			<option value="及格的">及格的</option>
			<option value="不及格的">不及格的</option>
			</select> 
			<br>
			<br>
			<center>
			<input class="easyui-linkbutton" type="submit" value="显示全部" style="width:70px">
			<input class="easyui-linkbutton" type="submit" value="查询" style="width:50px">
			</center>
			</form>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<table >
				<tr>
					<td>用户编号</td>
					<td>用户姓名</td>
					<td>成绩（20分制）</td>
					<td>试卷编号</td>
					<td>开始时间</td>
					<td>邮箱</td>
					<td>测试时长(秒)</td>
				</tr>
				<c:forEach items="${grades}" var="grade">
				<tr>
					<td>${grade.uid}</td>
					<td>${grade.uname}</td>
					<td>${grade.grade}</td>
					<td>${grade.testId}</td>
					<td>${grade.beginTime}</td>
					<td>${grade.email}</td>
					<td>${grade.usedTime}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	
</body>
</html>