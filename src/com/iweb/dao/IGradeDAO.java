package com.iweb.dao;
import java.util.List;

import com.iweb.entity.Grade;
public interface IGradeDAO {
	public List<Grade> getall() throws Exception;
	public boolean add(Grade grade) throws Exception;
	public boolean remove(int id1,int id2) throws Exception;
}
