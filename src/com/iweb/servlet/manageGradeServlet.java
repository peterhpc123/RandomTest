package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
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
 * Servlet implementation class manageGradeServlet
 */
@WebServlet("/user/manageGrade.action")
public class manageGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		GradeDAO gradeDAO=new GradeDAO();
		//UserDAO userDAO=new UserDAO();
		List<Grade> grades = null;
		//List<User> users = null;
		try {
			grades = gradeDAO.list();
			//users=userDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//测试数据
		/*for(int i=0;i<=grades.size();i++){
		out.println(grades.get(i).getUid());
		out.println(grades.get(i).getGrade());
		out.println(grades.get(i).getTestId());
		out.println(grades.get(i).getBeginTime());
		out.println(grades.get(i).getUsedTime());
		}*/
		request.setAttribute("grades", grades);
		//request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/view/manageScore.jsp").forward(request, response);
		
	}

}
