package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iweb.dao.impl.UserDAO;
import com.iweb.entity.User;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.login(loginname, password);
		PrintWriter out = response.getWriter();
		if(user != null){	
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	<style>a{color:blue}</style>");
			out.println("	</head>");
			out.println("	<body>");
			((HttpServletRequest)request).getSession().setAttribute("user", user);
			if("1".equals(user.getUlevel())){
				out.println("<div align=\"center\">欢迎 " + user.getUname() + ", 登录成功！<a href=\"/testweb/user/list.action\">点击进入管理考生页面</a></div>");
				out.println("<div align=\"center\" style=\"padding: 0 0 0 181px\"><a href=\"/testweb/user/manageGrade.action\">点击进入用户成绩界面</div>");
			}else{
				out.println("<div align=\"center\">欢迎 " + user.getUname() + ", 登录成功！<a href=\"/testweb/test.action?user="+user+"\""+">点击开始考试</a></div>");
			}
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}else{
			out.println("抱歉，您的用户名或密码输入错误！请重新输入！");
		}         
		
	}

}
