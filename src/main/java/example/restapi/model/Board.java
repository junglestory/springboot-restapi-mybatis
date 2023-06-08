package example.restapi.model;

import lombok.Data;

@Data
public class Board {
	int boardNo;
	String title;
	String contents;
	String writer;
	int viewCount;
    String createAt;
    String updateAt;
}