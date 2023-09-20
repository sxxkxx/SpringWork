package com.san.exam.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.exam.board.map.BoardMapper;
import com.san.exam.board.service.BoardService;
import com.san.exam.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {

		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {

		return boardMapper.updateBoard(boardVO);
	}

	@Override
	public int deleteBoardInfo(int boardNo) {

		return boardMapper.deleteBoard(boardNo);
	}

}
