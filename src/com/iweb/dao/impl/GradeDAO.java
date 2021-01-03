package com.iweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iweb.dao.IGradeDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.User;

public class GradeDAO extends BaseDAO implements IGradeDAO {

	@Override
	public List<Grade> getall() throws Exception {
		// TODO Auto-generated method stub
		List<Grade> grades = new ArrayList<Grade>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  grade ");
			rs = pstmt.executeQuery();
			while(rs.next()){
				grades.add(new Grade(rs.getInt("uid"),
						rs.getString("uname"),
						rs.getInt("marks"),
						rs.getInt("testId"),
						rs.getString("beginTime"),
						rs.getString("usedTime"),
						rs.getString("email")
						));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return grades;
	}

	@Override
	public boolean add(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into grade (uid,uname, marks,paperId,beginTime,email,usedTime) values (?,?,?,?,?,?,?)");
			pstmt.setInt(1, grade.getUid());
			pstmt.setString(2, grade.getUname());
			pstmt.setInt(3, grade.getGrade());
			pstmt.setInt(4, grade.getTestId());
			pstmt.setString(5, grade.getBeginTime());
			pstmt.setString(6, grade.getEmail());
			pstmt.setString(7, grade.getUsedTime());
			return pstmt.executeUpdate() > 0 ? true :false;	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}

	@Override
	public boolean remove(int id1,int id2) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("delete from grade where uid=?and paperId=?");
			pstmt.setInt(1, id1);
			pstmt.setInt(2, id2);
			return pstmt.executeUpdate() > 0 ? true:false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}
	public List<Grade> list() throws Exception {
		List<Grade> grades = new ArrayList<Grade>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from grade");
			rs = pstmt.executeQuery();
			while(rs.next()){
				grades.add(new Grade(rs.getInt("uid"), 
					rs.getString("uname"),
					rs.getInt("marks"),
					rs.getInt("paperId"),
					rs.getString("beginTime"),
					rs.getString("usedTime"),
					rs.getString("email")
				));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return grades;
	}
	public List<Grade> findPass(int marks) throws Exception {
		// TODO Auto-generated method stub
		//List<User> users = new ArrayList<User>();
		List<Grade> grades=new ArrayList<Grade>();
		//User user=new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from grade where  marks>=?");
			pstmt.setInt(1, marks);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				grades.add(new Grade(rs.getInt("uid"), 
					rs.getString("uname"),
					rs.getInt("marks"),
					rs.getInt("paperId"),
					rs.getString("beginTime"),
					rs.getString("email"),
					rs.getString("usedTime")
				)) ;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return grades;
	}
	public List<Grade> findFail(int marks) throws Exception {
		// TODO Auto-generated method stub
		//List<User> users = new ArrayList<User>();
		List<Grade> grades=new ArrayList<Grade>();
		//User user=new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from grade where marks<=?");
			pstmt.setInt(1, marks);
			rs = pstmt.executeQuery();
			while(rs.next()){
				grades.add(new Grade(rs.getInt("uid"), 
					rs.getString("uname"),
					rs.getInt("marks"),
					rs.getInt("paperId"),
					rs.getString("beginTime"),
					rs.getString("email"),
					rs.getString("usedTime")
				)) ;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return grades;
	}
}
