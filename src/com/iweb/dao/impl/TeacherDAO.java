package com.iweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iweb.dao.ITeacherDAO;
import com.iweb.entity.Teacher;
import com.iweb.entity.User;

public class TeacherDAO extends BaseDAO implements ITeacherDAO {
	public Teacher login(String Tno, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from teacher where Tno = ? and password = ?");
			pstmt.setString(1, Tno);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()){
				return new Teacher(rs.getInt("Tid"),Tno,password,rs.getString("Tname"),rs.getString("Tsex"),rs.getString("Tphone"),rs.getString("Temail"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public boolean add(Teacher teacher) {// if(true)return true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into teacher (Tno,password,Tname,Tsex,Tphone,Temail) values (?,?,?,?,?,?)");
			pstmt.setString(1, teacher.getTno());
			pstmt.setString(2, teacher.getPassWord());
			pstmt.setString(3, teacher.getTname());
			pstmt.setString(4, teacher.getTsex());
			pstmt.setString(5, teacher.getTphone());
			pstmt.setString(6, teacher.getTemail());
			return pstmt.executeUpdate() > 0 ? true :false;			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, pstmt, conn);
		}
		return false;
	}

	@Override
	public boolean remove(int id) throws Exception { //if(true)return true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("delete from teacher where Tid=?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0 ? true :false;			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, pstmt, conn);
		}
		return false;
	}

	@Override
	public List<Teacher> list() throws Exception {
		List<Teacher> teachers = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from teacher");
			rs = pstmt.executeQuery();
			while(rs.next()){
				teachers.add(new Teacher(rs.getInt("Tid"), 
					rs.getString("Tno"),
					rs.getString("password"),
					rs.getString("Tname"),
					rs.getString("Tsex"),
					rs.getString("Tphone"),
					rs.getString("Temail")
				)) ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return teachers;
	}

	@Override
	public int has(String Tno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Teacher find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
