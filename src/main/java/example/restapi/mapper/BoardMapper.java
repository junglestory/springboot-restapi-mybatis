package example.restapi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import example.restapi.model.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList() throws Exception;
	
	public Board selectBoard(int boardNo) throws Exception;
	
	public int insertBoard(Map<String, Object> params) throws Exception;
}