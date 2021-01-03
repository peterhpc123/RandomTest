package com.iweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iweb.dao.IPaperDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.Paper;

public class paperDAO extends BaseDAO implements IPaperDAO {

	@Override
	public Paper getone(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Paper> papers=new ArrayList<Paper>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		Paper paper=null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  paper where paperId=? ");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				papers.add(new Paper(rs.getInt("paperId"), rs.getInt("totaltime")));
			}
			paper=papers.get(0);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return paper;
	}
	public boolean add(int id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into paper (paperId,totalTime) values (?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, "50");
			return pstmt.executeUpdate() > 0 ? true :false;			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, pstmt, conn);
		}
		return false;
	}
}
