package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iweb.dao.impl.GradeDAO;
import com.iweb.dao.impl.UserDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.User;

/**
 * Servlet implementation class serach
 */
@WebServlet(name = "serachServlet", urlPatterns = { "/user/serachServlet" })
public class serachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String key= request.getParameter("key");//从后台管理界面传来的用户关键字
		String option=request.getParameter("select");//从后台管理界面传来的用户选项
		String flag=request.getParameter("flag");
		//System.out.println(flag);
		UserDAO userDAO = new UserDAO();
		GradeDAO gradeDAO=new GradeDAO();
		List<User> users = null;
		List<Grade> grades=null;
		if(flag.equals("user")&&key.equals("")){//显示全部
			try{
				users=userDAO.list();
				request.setAttribute("users", users);
				request.getRequestDispatcher("/WEB-INF/view/list-user.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(flag.equals("grade")&&key.equals("")){//显示全部
			try{
				grades=gradeDAO.list();
				request.setAttribute("grades", grades);
				request.getRequestDispatcher("/WEB-INF/view/manageScore.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(option.equals("姓名")){
			try{
				users=userDAO.find(key);
				request.setAttribute("users", users);
				request.getRequestDispatcher("/WEB-INF/view/list-user.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(option.equals("登录名")){
			try{
				users=userDAO.find1(key);
				request.setAttribute("users", users);
				request.getRequestDispatcher("/WEB-INF/view/list-user.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(option.equals("及格的")){
			try{
				
				grades=gradeDAO.findPass(Integer.parseInt(key));
				request.setAttribute("grades", grades);
				request.getRequestDispatcher("/WEB-INF/view/manageScore.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(option.equals("不及格的")){
			try{
				grades=gradeDAO.findFail(Integer.parseInt(key));
				request.setAttribute("grades", grades);
				request.getRequestDispatcher("/WEB-INF/view/manageScore.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
