package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.iweb.dao.impl.UserDAO;
import com.iweb.entity.User;

public class RegServlet implements Servlet {

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		    
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birthday");
		String uname = request.getParameter("uname");
		out.println(uname);
		//out.println(birth);
		User user = new User(0, loginname, password, email, phone, sex, birth, uname, "0");
		UserDAO userDAO = new UserDAO();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		if(userDAO.add(user)){
			out.println("	恭喜，注册成功！<a href=\"/testweb/login.html\">进入登录页面</a>");
		}else{
			out.println("	抱歉，注册失败！<a href=\"/testweb/reg.html\">回到首页</a>");
		}
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
