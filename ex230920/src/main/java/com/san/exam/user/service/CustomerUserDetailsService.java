package com.san.exam.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.san.exam.user.map.UserMapper;

public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO userVO = userMapper.getUser(username);
						
		// 인증정보를 리턴해야함
		if(userVO == null) {
			throw new UsernameNotFoundException("No User");
		}
		
		return userVO;
	}

}
