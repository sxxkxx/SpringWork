package com.san.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.san.app.emp.mapper.EmpMapper;
import com.san.app.emp.service.EmpVO;

@Controller
public class EmpController {

	@Autowired
	EmpMapper empMapper;

	// get: 조회, 빈페이지 요청
	// 그외(post, delete, put): 등록, 수정, 삭제

	// @RequestMapping(value ="empForm", method =RequestMethod.GET) // value = path
	@GetMapping("empForm")
	public void getEmpInfoForm() {
	}

	@GetMapping("getEmp")
	public String getEmpData(EmpVO empVO, Model model) {
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}

	@GetMapping("getEmpData")
	public String getEmpData(@RequestParam(defaultValue = "100", name = "eId", required = true) Integer employeeId,
			Model model) {
		EmpVO empVO = new EmpVO();

		empVO.setEmployeeId(employeeId);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}

	@GetMapping("emp/{id}")
	public String getEmpData2(@PathVariable(name = "id") Integer employeeId, Model model) {
		
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "empForm";
	}
	
	@PostMapping("empInfoInsert")
	public String empInfoInsert(@RequestBody EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println("결과 : "+ empVO.getEmployeeId());
		return "empForm";
	}
	
	
}
