package com.san.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.san.app.emp.service.EmpService;
import com.san.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class TxTest {
	
		
	@Autowired
	EmpService empService;
	
	@Test
	public void insert() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		empService.getEmp(empVO);
	}
}
