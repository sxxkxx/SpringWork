package com.san.app.emp.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.app.emp.Service.EmpService;
import com.san.app.emp.Service.EmpVO;
import com.san.app.emp.map.EmpMapper;


@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getEmpList() {

		return empMapper.selectAllEmp();
	}

	@Override
	public EmpVO getEmpInfo(EmpVO empVO) {
		
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmpInfo(EmpVO empVO) {
		
		return empMapper.insertEmpInfo(empVO);
	}

}
