package com.san.exam.board.map;

import java.util.List;

import com.san.exam.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectBoardList();

	// 단건조회 : 조건 1) 글번호 ,2) 특정작성자와 글번호
	public BoardVO selectBoardInfo(BoardVO boardVO);

	// 등록 : 1) 필수조건 옵션 구분 2)bno 자동부여
	public int insertBoard(BoardVO boardVO);

	// 수정 : 대상(제목, 내용, 이미지, 수정날짜)
	// -> image는 빈 값 허용 / 수정 날짜 필수
	public int updateBoard(BoardVO boardVO);

	// 삭제
	public int deleteBoard(int boardNo);
}
