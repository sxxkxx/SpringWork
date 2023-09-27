package com.san.exam.user.map;

import com.san.exam.user.service.UserVO;

public interface UserMapper {
	public UserVO getUser(String username);
}
