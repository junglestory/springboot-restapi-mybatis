package example.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import example.restapi.mapper.BoardMapper;
import example.restapi.model.Board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@Service
public class BoardService {
    static final Logger logger = (Logger) LoggerFactory.getLogger(BoardService.class);

    @Autowired
    BoardMapper boardMapper;

	/**
	 * 게시판 등록
	 * @param board
	 * @return
	 */
	public Map<String, Object> registBoard(Board board) {
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 Map<String, Object> paramMap = new HashMap<String, Object>();
        
		 try {
	         paramMap.put("title", board.getTitle());
	         paramMap.put("contents", board.getContents());
	         paramMap.put("writer", board.getWriter());
	         paramMap.put("viewCount", 0);	         
	         	                  
	         int ret = boardMapper.insertBoard(paramMap);         
	         	         	         
	         if (ret > 0) {
	        	 resultMap.put("result", "success");
	         } else {
	        	 resultMap.put("result", "failed");
	         }
	         
	         resultMap.put("status", HttpStatus.CREATED);
		 } catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			
			logger.error(ex.getMessage());
		 }
		 
		 return resultMap;
   }
}