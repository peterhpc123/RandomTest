

package com.iweb.sendMail;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * Servlet implementation class SendAttachEmail
 */
@WebServlet("/user/sendMailServlet")
public class sendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 接收邮件数据
		String to_mail = request.getParameter("to");
		out.println(to_mail);
		// String from=request.getParameter("from");
		String to_title = request.getParameter("title");
		String to_content = request.getParameter("content");
		//String password = request.getParameter("password");
		
		/*---------建立邮件会话-------------------*/
		Properties props = new Properties();
		props.put("mail.smtp.port","25");
		props.put("mail.smtp.host", "smtp.qq.com");// 存储发送邮件服务器的信息 
		props.put("mail.smtp.auth", "true");// 同时通过验证
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Session session = Session.getInstance(props);// 根据属性新建一个邮件会话
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		session.setDebug(true); 
		
		try {
			/*--------------------设置邮件头-------------*/
			// 由邮件会话新建一个消息对象
			MimeMessage message = new MimeMessage(session);
			// 设置发件人
			message.setFrom(new InternetAddress("2990314711@qq.com"));
			// 设置收件人,并设置其接收类型为TO
			InternetAddress to = new InternetAddress(to_mail);
			message.setRecipient(MimeMessage.RecipientType.TO,to);
			message.setSubject(to_title);// 设置主题
			message.setText(to_content);//设置内容
			//message.setContent(to_content);
			//message.saveChanges();
			
			/*--------------------设置带附件的邮件体-------------*/
			/*// 新建一个MimeMultipart对象用来存放多个BodyPart对象，这是一个容器对象
			Multipart multipart = new MimeMultipart();

			// 设置信件文本内容---第一个body
			BodyPart bodyPort1 = new MimeBodyPart();// 新建一个存放信件内容的BodyPart对象
			// 设置BodyPart对象设置内容和格式/编码方式,第一个参数为邮件内容，第二个参数为格式和编码
			bodyPort1.setContent(to_content, "text/html;charset=utf-8");
			multipart.addBodyPart(bodyPort1);// 将含有信件内容的BodyPart加入到MimeMultipart容器中

			// 设置信件的附件-第二个body
			BodyPart bodyPort2 = new MimeBodyPart();
			
		   
			FileDataSource fds = new FileDataSource("d:/test/a.txt");
			DataHandler dh = new DataHandler(fds);
			bodyPort2.setFileName("a.txt");// 可以和原文件名不一致
			bodyPort2.setDataHandler(dh);
			multipart.addBodyPart(bodyPort2);
*/
			//message.setContent(multipart);// 把作multipart为消息对象的内容
			message.setSentDate(new Date());// 设置发信时间
			message.saveChanges();// 存储邮件信息

			/*-------------------发送邮件--------------*/
			Transport transport = session.getTransport("smtp");
			/*
			 * 以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址 第二个参数为用户名,第三个参数为密码
			 */
			transport.connect("smtp.qq.com", "2990314711@qq.com","rkdzeijpdikwdehi");
			// 发送邮件,其中第二个参数是所有已设好的收件人地址
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			out.print("邮件发送成功!");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			out.print(e.toString());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			out.print("邮件发送失败!");
			out.print(e.toString());
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
