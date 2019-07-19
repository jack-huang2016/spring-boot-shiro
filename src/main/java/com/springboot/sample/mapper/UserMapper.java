package com.springboot.sample.mapper;

import com.springboot.sample.entity.User;

public interface UserMapper {
	/**
	 * 根据用户名获取用户实体
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
}
