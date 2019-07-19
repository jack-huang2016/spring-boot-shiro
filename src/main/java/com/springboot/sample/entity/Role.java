package com.springboot.sample.entity;

import lombok.Data;

@Data
public class Role {

	/**
	 * 编号
	 */
	private Integer id; 
	
	/**
	 *  角色名称
	 */
	private String roleName; 
	
	/**
	 * 备注
	 */
	private String remarks;
}
