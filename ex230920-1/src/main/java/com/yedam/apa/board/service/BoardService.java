package com.yedam.apa.board.service;

import java.util.List;

public interface BoardService {
	// 전체 조회
	public List<BoardVO> getBoardList();

	// 단건 조회
	public BoardVO getBoardInfo(BoardVO boardVO);

	// 등록 - 반환 : 등록된 글 번호 or -1
	public int insertBoardInfo(BoardVO boardVO);

	// 수정 - 반환 : 수정된 글 번호 or -1
	public int updateBoardInfo(BoardVO boardVO);

	// 삭제 - 반환 : 삭제된 글 번호 or -1
	public int deleteBoardInfo(int boardNo);
}
