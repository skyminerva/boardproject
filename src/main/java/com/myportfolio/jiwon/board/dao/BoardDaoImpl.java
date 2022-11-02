package com.jiwon.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jiwon.board.dto.BoardDto;
import com.jiwon.board.dto.SearchCondition;

@Repository
public abstract class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.jiwon.board.dao.BoardMapper.";
	
	public int count() throws Exception {
		return session.selectOne(namespace+"count");
	}
	
	@Override
	public int deleteAll() {
		return session.delete(namespace+"deleteAll");
	}
	
	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("writer", writer);
		return session.delete(namespace+"delete", map);
	}
	
	public int insert(BoardDto dto) throws Exception {
		return session.insert(namespace+"insert", dto);
	} 
	
	@Override
	public List<BoardDto> selectAll() throws Exception {
		return session.selectList(namespace+"selectAll");
	} 

	public BoardDto select(Integer bno) throws Exception {
		return session.selectOne(namespace + "select", bno);
	}
	
	@Override
	public List<BoardDto> selectPage(Map<String, Object> map) throws Exception {
		return session.selectList(namespace+"selectPage", map);
	}
	
	@Override
	public int update(BoardDto dto) throws Exception {
		return session.update(namespace+"update", dto);
	}
	@Override
	public int increaseViewCnt(Integer bno) throws Exception {
		return session.update(namespace+"increaseViewCnt", bno);
	}

	@Override
	public int searchResultCnt(SearchCondition sc) throws Exception {
		System.out.println("sc in searchResultCnt() = " + sc);
		System.out.println("session = " + session);
		return session.selectOne(namespace+"searchResultCnt", sc);
	}
	@Override
	public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
		return session.selectList(namespace+"searchSelectPage", sc);
	}
}
