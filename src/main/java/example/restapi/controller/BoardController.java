package example.restapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.restapi.model.Board;
import example.restapi.service.BoardService;

@RestController
public class BoardController {
	@Autowired
    BoardService boardService;

	/**
	 * 게시판 등록 
	 * @param baord
	 * @return
	 * @throws Exception
	 */
	 @PostMapping(value = "/board", produces = "application/json")
	 public Map<String, Object> registBoard(@RequestBody Board board) throws Exception {
	      return boardService.registBoard(board);
	 }
}