package com.san.app.emp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.app.emp.service.EmpService;
import com.san.app.emp.service.EmpVO;

import lombok.Delegate;

@RestController
public class EmpRestController {
	@Autowired
	EmpService empService;

	// 전체조회 : Get + Uri
	@GetMapping("emps")
	public List<EmpVO> getEmpAllList() {
		return empService.getEmpAll();
	}

	// 단건조회 : Get + Uri + @PathVariable
	@GetMapping("emps/{empId}")
	public EmpVO getEmpInfo(@PathVariable int empId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(empId);
		return empService.getEmp(empVO);
	}

	// 등록 : Post + Uri + @RequestBody
	@PostMapping("emps")
	public int insertEmpInfo(@RequestBody EmpVO empVO) {
		return empService.insertEmp(empVO);
	}

	// 수정 : PUT + Uri + @PathVariable, @RequestBody
	@PutMapping("emps/{empId}")
	public Map<String, String> updateEmpInfo(@PathVariable int empId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(empId);
		return empService.updateEmp(empVO);
	}
	
	// 삭제 : Delete + Uri + @PathVariable
	@DeleteMapping("emps/{empId}")
	public Map<String, Object>deleteEmpInfo(@PathVariable int empId){
		List<Integer> list = new ArrayList<>();
		list.add(empId);
		return empService.deleteEmp(list);
	}
		
	
	
}
