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
		<h3 style="text-align:center" >总共${fn:length(users)}位用户</h3>
		</div>
		<div data-options="region:'south',split:true" style="height:50px; text-align:center">
		Copyright © 2013-2018 洪鹏程  onlinetest.com All Rights Reserved. 
		</div>
		<div data-options="region:'east',split:true" title="East" style="width:200px;"><!-- 右栏 -->
			<h4 style="text-align:center; padding: 20px; margin: 0 0;background-color: #E0ECFF;">通告</h4>
		</div>
		<div data-options="region:'west',split:true" title="West" style="width:200px;"><!-- 左栏 -->
			<h4 style="text-align:center; padding: 20px; margin: 0 0;background-color: #E0ECFF;">综合查询区域</h4>
			<form action="/testweb/user/serachServlet?flag=user" method="post">
			<br>
			<span style="font-size:14px">关键字：</span>
			<input class="easyui-textbox" id="key" type="text" name="key" style="width:120px">
			<br>
			<br>
			<span style="font-size:14px">选条件：</span>
			<select class="easyui-combobox" id="selected" name="select" style="width:120px">
			<option value="登录名">登录名</option>
			<option value="姓名">姓名</option>
			</select> 
			<br>
			<br>
			<center><input class="easyui-linkbutton" type="submit" value="显示全部" style="width:70px">
			<input class="easyui-linkbutton" type="submit" value="查询" style="width:50px"></center>
			</form>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<table >
				<tr>
					<td>ID</td>
					<td>登录名</td>
					<td>登录密码</td>
					<td>邮箱</td>
					<td>性别</td>
					<td>联系方式</td>
					<td>姓名</td>
					<td>其他</td>
				</tr>
				<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.loginname}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.sex}</td>
					<td>${user.phone}</td>
					<td>${user.uname}</td>
					<td>
						<c:if test="${user.id != sessionScope.user.id and '1'==sessionScope.user.ulevel}">
						<a href="/testweb/user/remove.action?id=${user.id}">删除</a>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</div>
		<script type="text/javascript">
		
		/* $('#submit').click(function(){
		   	$.ajax({
		   		type: "POST",
             	url: "/testweb/user/serachServlet",
             	data:form
		   	})
		}) */
		</script>
		
</body>
</html>