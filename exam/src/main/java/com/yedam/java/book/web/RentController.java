package com.yedam.java.book.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.java.book.service.RentService;

@Controller
public class RentController {
	@Autowired
	RentService service;
	
	@GetMapping("rentList")
	public String getRentList(Model model) {
		List<Map<String, Object>> rentList = service.getRentList();
		model.addAttribute("rentList", rentList);
		return "book/rentList";
	}
}
