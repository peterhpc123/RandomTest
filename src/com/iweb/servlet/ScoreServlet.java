package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iweb.dao.impl.GradeDAO;
import com.iweb.dao.impl.paperDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.Paper;
import com.iweb.entity.Question;
import com.iweb.entity.User;

public class ScoreServlet implements Servlet{

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		GradeDAO gradeDAO=new GradeDAO();
		PrintWriter out=response.getWriter();
		paperDAO paDao=new paperDAO();
		int paperId=(int)((HttpServletRequest)request).getSession().getAttribute("PaperId");
		Paper paper=null;
		try {
			paper=paDao.getone(paperId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int score = 0;
		int i=0,j=0;
		Grade grade=new Grade();
		User user=null;
		user=(User)((HttpServletRequest)request).getSession().getAttribute("user");
		//out.println(user.getUname());
		String beginTime=(String)((HttpServletRequest)request).getSession().getAttribute("beginTime");
		//out.println(beginTime);
		//out.println(paperId);
		String usedTime=request.getParameter("usedTime");//获取从testservlet中得到的参数
		int usedtime=Integer.parseInt(usedTime);
		int totalTime=paper.getTotalTime();
		int remainTime=(totalTime*60-usedtime);//得到使用了的时间
		String reString=String.valueOf(remainTime);
		List<Question> questions = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions2");
		List<Question> questionj = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questionj2");
		//out.println(questions.get(1).getQid());
		//System.out.println("score" + questions.size());
		for(Question question : questions){
			//System.out.println((i++)+"."+request.getParameter(Integer.toString(question.getQid())));
			//out.println(questions.get(i++).getQid());
			if(question.getAnswer().equals(request.getParameter("s"+Integer.toString(question.getQid())))){
				score++;
			}
		}
		//out.println(score);
		for(Question question : questionj){
			//System.out.println((j++)+"."+request.getParameter(Integer.toString(question.getQid())));
			//out.println(questionj.get(j++).getQid());
			if(question.getAnswer().equals(request.getParameter("j"+Integer.toString(question.getQid())))){//对应问题的答案跟提交问题的值相等则正确
				score=score+2;
				
			}
		}
		//out.println(score);
		//将该用户的数据提交到数据库
		grade.setBeginTime(beginTime);
		grade.setGrade(score);
		grade.setTestId(paperId);
		grade.setUsedTime(reString);
		grade.setEmail(user.getEmail());
		grade.setUid(user.getId());
		grade.setUname(user.getUname());
		try {
			gradeDAO.add(grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("<link rel='stylesheet' type='text/css' href='css/easyui.css'>");
		out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
		out.println("<script type='text/javascript' src='js/jquery.easyui.min.js'></script>");
		out.println("<script type='text/javascript' src='js/easyui-lang-zh_CN.js'></script>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("<center>");
		out.println("	<h3>考试完毕！祝你取得好成绩</h3>");
		out.println("<a href=\"/testweb/login.html\" class=\"easyui-linkbutton\" >返回首页</a>");
		out.println("</center>");
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
