package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import sun.text.normalizer.UTF16;

import com.iweb.dao.impl.QuestionDAO;
import com.iweb.dao.impl.paperDAO;
import com.iweb.entity.Paper;
import com.iweb.entity.Question;
import com.iweb.entity.User;
import com.mysql.fabric.xmlrpc.base.Data;


public class TestServlet implements Servlet{

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
		PrintWriter out = response.getWriter();
		User user=new User();
		user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		paperDAO paperDAO=new paperDAO();
		Paper paperone=null;
		try{
		paperDAO.add(user.getId());//根据用户的id创建一个唯一的试卷编号
		paperone=paperDAO.getone(user.getId());
		}catch(Exception e){
			
		}
//		String question = request.getParameter("question");
//		String answer = request.getParameter("answer");
		int PaperId=paperone.getPaperId();//获取试卷标编号
		Date currDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String beginT = sdf.format(currDate);
		QuestionDAO questionDAO = new QuestionDAO();
		List<Question> questions = null;//所有单选题列表
		List<Question> questionj=null;//所有单选题列表
		List<Question> questions2=new ArrayList<Question>();
		List<Question> questionj2=new ArrayList<Question>();
		long totalTime=paperone.getTotalTime()*60;//总时间秒
		try {
			questions = questionDAO.single();//从数据库中选择的单选题随机排序
			questionj=questionDAO.judgement();//从数据库中选择的多选题随机排序
		} catch (Exception e) {
			e.printStackTrace();
		}
		((HttpServletRequest)request).getSession().setAttribute("beginTime", beginT);
		((HttpServletRequest)request).getSession().setAttribute("PaperId", PaperId);
		
		
		
		//System.out.println("test:" + q.size());
		//out.println(beginT);
		out.println(user.getId());
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("<link rel='stylesheet' type='text/css' href='css/easyui.css'>");
		out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
		out.println("<script type='text/javascript' src='js/jquery.easyui.min.js'></script>");
		out.println("<script type='text/javascript' src='js/easyui-lang-zh_CN.js'></script>");

		out.println("<script type='text/javascript' src='js/getremainTime.js'></script>");
		
		out.println("	</head>");
		out.println("	<body>");
		//out.println(user.getId());
		out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
		out.println("<form id=\"form1\" name=\"form1\" action=\"/testweb/score.action?user="+user+"\""+" method=\"post\" onSubmit=\"check(this)\">");
		out.println("<div class='easyui-tabs' style='width:500px;height:20px;margin:0 auto'>");
		out.println("试卷编号："+PaperId);
		out.println("<input hidden style=\"float: right;width: 50px;\" class=\"easyui-testbox\" required id=\"remainingTime\" name=\"usedTime\" value="+totalTime+">");
		out.println("<a href=\"javascript:void(0)\" style=\"text-decoration:none;float:right;color:black\" id=\"time\"></a>"+"<a style=\"float:right;color:black;text-decoration:none;\">考试剩余时间：</a>");
		out.println("</div>");
		out.println("<div class='easyui-tabs' style='width:500px;height:700px;margin:0 auto'>");
		out.println("<div title='单选题：共10*1分' style='padding:10px'>");
		out.println("	<ol id='question'>");
		int flag1 = 0;
		for(Question single : questions){
			out.println("<li name=\"single\">");
			out.println(single.getQuestion() + "<br/>");
			out.println("<input type=\"radio\" name=\"" +"s"+ single.getQid() + "\" value=\"A\">" + single.getCheck()[0] + "<br/>");
			out.println("<input type=\"radio\" name=\"" +"s"+ single.getQid() + "\" value=\"B\">" + single.getCheck()[1] + "<br/>");
			out.println("<input type=\"radio\" name=\"" +"s"+ single.getQid() + "\" value=\"C\">" + single.getCheck()[2] + "<br/>");
			out.println("<input type=\"radio\" name=\"" +"s"+ single.getQid() + "\" value=\"D\">" + single.getCheck()[3] + "<br/>");	
			out.println("</li>");
			flag1++;
			questions2.add(single);
			if(flag1 == 10){
				break;
			}
			
		}
		((HttpServletRequest)request).getSession().setAttribute("questions2", questions2);//设置单选题会话属性
		out.println("	</ol>");
		out.println("	</div>");
		out.println("<div title='判断题：共5*2分' style='padding:10px'>");
		out.println("	<ol id='question'>");
		int flag2 = 0;
		for(Question judge : questionj){
			out.println("<li name=\"judgement\">");
			out.println(judge.getQuestion() + "<br/>");
			out.println("<input type=\"radio\" name=\"" +"j"+ judge.getQid() + "\" value=\"对\">" + "对" + "<br/>");
			out.println("<input type=\"radio\" name=\""+"j" + judge.getQid() + "\" value=\"错\">" + "错" + "<br/>");
			out.println("</li>");
			flag2++;
			questionj2.add(judge);
			if(flag2 == 5){
				break;
			}
		}
		((HttpServletRequest)request).getSession().setAttribute("questionj2", questionj2);//设置多选题会话属性
		out.println("	</ol>");
		out.println("	</div>");
		out.println("	</div>");
		out.println("	<div style=\" width: 200px;margin:0 auto\">");
		out.println("	<a  href=\"/testweb/score.action?user="+user+"\""+"><input class=\"easyui-linkbutton\" style=\"width:50px\" type=\"submit\" value=提交></a>");
		out.println("	</div>");
		out.println("</form>");
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
		// TODO Auto-generated method stub
		
	}

