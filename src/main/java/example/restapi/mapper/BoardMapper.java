package example.restapi.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	public int insertBoard(Map<String, Object> params) throws Exception;
}