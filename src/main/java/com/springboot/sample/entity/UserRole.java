package com.springboot.sample.entity;

import lombok.Data;

@Data
public class UserRole {
	
	/**
	 * 编号
	 */
	private Integer id;
	
	/**
	 * 用户
	 */
	private User user;
	
	/**
	 * 角色
	 */
	private Role role;
	
	/**
	 * 备注
	 */
	private String remarks;
}
