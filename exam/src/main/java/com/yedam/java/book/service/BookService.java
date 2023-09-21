package com.yedam.java.book.service;

import java.util.List;


public interface BookService {
	// 전체 조회
	public List<BookVO> getBookList();
	
	// 단건 조회
	public BookVO getBookInfo(BookVO vo);
	
	// 책번호+1
	public int getNextBookNo();
	
	// 등록
	public int insertBook(BookVO vo);
}
