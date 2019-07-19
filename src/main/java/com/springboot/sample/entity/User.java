package com.springboot.sample.entity;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {

	private Integer id;
	
	/**
	 * 用户名
	 */
	@NotEmpty(message = "用户名不能为空")
	private String userName;  
	
	/**
	 * 密码
	 */
	@NotEmpty(message = "密码不能为空")
	private String password;  
	
	/**
	 * 备注
	 */
	private String remarks;
}
