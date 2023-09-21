package com.yedam.java.book.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.RentMapper;
import com.yedam.java.book.service.RentService;


@Service
public class RentServiceImpl implements RentService {
	@Autowired
	RentMapper mapper;

	@Override
	public List<Map<String, Object>> getRentList(){

		return mapper.getRentList();
	}

}
