package com.jiwon.board.service;

import java.util.List;
import java.util.Map;

import com.jiwon.board.dto.BoardDto;
import com.jiwon.board.dto.SearchCondition;

public interface BoardService {
	
	int getCount() throws Exception;
	
	int remove(Integer bno, String writer) throws Exception;
	
	int write(BoardDto boardDto) throws Exception;
	
	List<BoardDto> getList() throws Exception;
	
	BoardDto read(Integer bno) throws Exception;
	
	List<BoardDto> getPage(Map<String, Object> map) throws Exception;
	
	int modify(BoardDto boardDto) throws Exception;
	
	List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;
	
	int getSearchResultCnt(SearchCondition sc) throws Exception;
}
