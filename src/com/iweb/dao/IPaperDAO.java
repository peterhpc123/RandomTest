package com.iweb.dao;

import java.util.List;

import com.iweb.dao.impl.paperDAO;
import com.iweb.entity.Paper;

public interface IPaperDAO {
	public Paper getone(int id) throws Exception;
}
