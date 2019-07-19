package com.springboot.sample.entity;

import lombok.Data;

@Data
public class Permission {
	
	/**
	 * 编号
	 */
	private Integer id;
	
	/**
	 * 菜单名称
	 */
	private String permissionName;
	
	/**
	 * 备注
	 */
	private String remarks;
}
