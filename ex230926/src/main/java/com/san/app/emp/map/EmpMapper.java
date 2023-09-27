package com.san.app.emp.map;

import java.util.List;

import com.san.app.emp.Service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selectAllEmp();

	// 단건 조회
	public EmpVO selectEmpInfo(EmpVO empVO);

	// 등록
	public int insertEmpInfo(EmpVO empVO);

}
