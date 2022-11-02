package com.jiwon.board.dao;

import java.util.List;
import java.util.Map;

import com.jiwon.board.dto.BoardDto;
import com.jiwon.board.dto.SearchCondition;

public interface BoardDao {
	
	BoardDto select(Integer bno) throws Exception;
	
	int delete(Integer bno, String writer) throws Exception;
	
	int insert(BoardDto dto) throws Exception;
	
	int update(BoardDto dto) throws Exception;
	
	int increaseViewCnt(Integer bno) throws Exception;
	
	List<BoardDto> selectPage(Map<String, Object> map) throws Exception;
	
	List<BoardDto> selectAll() throws Exception;
	
	int deleteAll() throws Exception;
	
	int count() throws Exception;
	
	int searchResultCnt(SearchCondition sc) throws Exception;
	
	List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;
}
