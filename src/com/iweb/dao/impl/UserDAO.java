package com.iweb.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iweb.dao.IUserDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.User;


/**
 * 天津理工大学计算机科学与工程学院 版权所有 2017 Copyright(C) 2017 All rights reserved.
 * @version 1.0
 * @author 洪鹏程
 * @data June 20,2018
 */
public class UserDAO extends BaseDAO implements IUserDAO{

	@Override
	public User login(String loginname, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from TEST_USER where loginname = ? and password = ?");
			pstmt.setString(1, loginname);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()){
				return new User(rs.getInt("id"), 
					loginname, 
					password, 
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("sex"),
					rs.getString("birth"),
					rs.getString("uname"),
					rs.getString("ulevel"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public boolean add(User user) {// if(true)return true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into TEST_USER (loginname, password, email, phone, sex, birth, uname,ulevel) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getLoginname());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getSex());
			pstmt.setString(6, user.getBirth());
			pstmt.setString(7, user.getUname());
			pstmt.setString(8, user.getUlevel());
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
			pstmt = conn.prepareStatement("delete from TEST_USER where id=?");
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
	public List<User> list() throws Exception {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from TEST_USER");
			rs = pstmt.executeQuery();
			while(rs.next()){
				users.add(new User(rs.getInt("id"), 
					rs.getString("loginname"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("sex"),
					rs.getString("birth"),
					rs.getString("uname"),
					rs.getString("ulevel"))
				) ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return users;
	}

	@Override
	public boolean has(String loginname) throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean hasIt=false;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from TEST_USER where loginname=?");
			pstmt.setString(1, loginname);
			rs = pstmt.executeQuery();
			if (rs.next())
				hasIt=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return hasIt;
	}

	@Override
	public List<User> find(String uname) throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		//User user=new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from TEST_USER where uname=?");
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
			while(rs.next()){
				users.add(new User(rs.getInt("id"), 
					rs.getString("loginname"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("sex"),
					rs.getString("birth"),
					rs.getString("uname"),
					rs.getString("ulevel"))
				) ;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return users;
	}
	public List<User> find1(String loginname) throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		//User user=new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from TEST_USER where loginname=?");
			pstmt.setString(1, loginname);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				users.add(new User(rs.getInt("id"), 
					rs.getString("loginname"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("sex"),
					rs.getString("birth"),
					rs.getString("uname"),
					rs.getString("ulevel"))
				) ;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
		}
		return users;
	}
	
	@Override
	public User find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
