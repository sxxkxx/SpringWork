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
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoard(boardVO);
		System.out.println(result);
		if(result != 0) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
		//return boardMapper.updateBoard(boardVO) == 1 ? Integer.valueOf(boardVO.getBno()) : -1;
		// 3항 연산자 - 조건식 ? true : false ;
	}

	@Override
	public int deleteBoardInfo(int boardNo) {
		int result = boardMapper.deleteBoard(boardNo);
		return result == 1 ? boardNo : -1;
	}

}
