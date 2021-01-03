package com.iweb.dao;

import java.util.List;

import com.iweb.entity.Teacher;

public interface ITeacherDAO {
	/**
	 * 注册
	 */
	public boolean add(Teacher teacher) throws Exception ;
	
	/**
	 * 删除
	 */
	public boolean remove(int id) throws Exception ;
	
	/**
	 * 获得教师列表
	 */
	public List<Teacher> list() throws Exception ;
	
	/**
	 * 登录
	 */
	public Teacher login(String Tno, String password) throws Exception ;
	
	/**
	 * 检测教师的唯一性
	 */
	public int has(String loginname) throws Exception ;
	
	/**
	 * 根据ID查找用户
	 */
	public Teacher find(int id) throws Exception ;
}
