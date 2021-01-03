package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iweb.dao.impl.TeacherDAO;
import com.iweb.entity.Teacher;

/**
 * Servlet implementation class teacherManage
 */
@WebServlet("/user/teacherManage")
public class teacherManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String Tno = request.getParameter("Tno");
		String Tpassword = request.getParameter("Tpassword");
		TeacherDAO teacherDAO=new TeacherDAO();
		Teacher teacher=teacherDAO.login(Tno, Tpassword);
		if(teacher!=null){
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("/WEB-INF/view/manageExam.jsp").forward(request, response);
		}else{
			out.println("抱歉，您的教师编号或密码输入错误！请重新输入！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
