package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("bookList")
	public String getBookList(Model model) {
		List<BookVO> bookList = service.getBookList();
		model.addAttribute("bookList", bookList);
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String insertBookForm(Model model) {
		int result = service.getNextBookNo();
		model.addAttribute("nextNo", result);
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String insertBookProcess(BookVO vo) {
		service.insertBook(vo);
		return "book/bookList";
	}
	
	
	
}
