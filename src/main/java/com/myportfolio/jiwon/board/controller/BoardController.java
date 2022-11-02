package com.jiwon.board.controller;

import com.jiwon.board.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public String list(HttpServletRequest request) {

		return "boardList"; 
	}

}