package com.san.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.san.app.emp.Service.EmpService;
import com.san.app.emp.Service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	// 전체조회
	@GetMapping("empList")
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpList();
		model.addAttribute("empList", list);
		return "empList"; // src/main/resources/..
	}
	
	// 단건조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empInfo";
	}
	
	// 등록 - 페이지
	@GetMapping("empInsert")
	public String insertEmpForm(Model model) {
		model.addAttribute("empVO", new EmpVO()); // thymleaf
		return "empInsert";
	}
	
	// 등록 - 처리
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
