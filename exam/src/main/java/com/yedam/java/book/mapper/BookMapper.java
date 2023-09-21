package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> getBookList();
	public BookVO getBookInfo(BookVO vo);
	public int getNextBookNo();
	public int insertBook(BookVO vo);
}
