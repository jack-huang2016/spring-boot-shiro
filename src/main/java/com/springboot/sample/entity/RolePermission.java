package com.springboot.sample.entity;

import lombok.Data;

@Data
public class RolePermission {
	
	/**
	 * 编号
	 */
	private Integer id;
	
	/**
	 * 角色
	 */
	private Role role;
	
	/**
	 * 菜单
	 */
	private Permission menu;
	
	/**
	 * 备注
	 */
	private String remarks;
}
