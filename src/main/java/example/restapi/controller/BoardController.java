package example.restapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.restapi.model.Board;
import example.restapi.service.BoardService;

@RestController
public class BoardController {
	@Autowired
    BoardService boardService;

	/**
	 * 게시판 목록 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/board", produces = "application/json")
    public Map<String, Object> listBoard() throws Exception {
        return boardService.getBoardList();
    }
	
	/**
	 * 게시판 조회 
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/board/{boardNo}", produces = "application/json")
    public Map<String, Object> getBoard(@PathVariable("boardNo") int boardNo) throws Exception {
        return boardService.getBoard(boardNo);
    }
	
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
	 
	 /**
	  * 게시판 수정 
	  * @param baord
	  * @return
	  * @throws Exception
	  */
	 @PutMapping(value = "/board", produces = "application/json")
	 public Map<String, Object> modifyBoard(@RequestBody Board baord) throws Exception {
		 return boardService.modifyBoard(baord);
	 }
	 
	 /**
	  * 게시판 삭제 
	  * @param boardNo
	  * @return
	  * @throws Exception
	  */
	 @DeleteMapping(value = "/board/{boardNo}", produces = "application/json")
	 public Map<String, Object> deleteBoard(@PathVariable("boardNo") int boardNo) throws Exception {
		 return boardService.deleteBoard(boardNo);
	 }
}