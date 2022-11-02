package com.jiwon.board.service;

import com.jiwon.board.dao.*;
import com.jiwon.board.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public abstract class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;
	
	@Override
	public int getCount() throws Exception {
		return boardDao.count();
	}
	
	@Override
	public int remove(Integer bno, String writer) throws Exception {
		return boardDao.delete(bno, writer);
	}
	
	@Override
	public int write(BoardDto boardDto) throws Exception {
		return boardDao.insert(boardDto);
	}
	
	@Override
	public List<BoardDto> getList() throws Exception {
		return boardDao.selectAll();
	}
	
	@Override
	public BoardDto read(Integer bno) throws Exception {
		BoardDto boardDto = boardDao.select(bno);
		boardDao.increaseViewCnt(bno);
		
		return boardDto;
  	}
	
	@Override
	public List<BoardDto> getPage(Map<String, Object> map) throws Exception {
		return boardDao.selectPage(map);
	}
	
	@Override
	public int modify(BoardDto boardDto) throws Exception {
		return boardDao.update(boardDto);
	}
	
	@Override
	public int getSearchResultCnt(SearchCondition sc) throws Exception {
		return boardDao.searchResultCnt(sc);
	}

	@Override
	public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
		return boardDao.searchSelectPage(sc);
	}
}
