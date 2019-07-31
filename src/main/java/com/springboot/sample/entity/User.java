package com.springboot.sample.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6849721258664049759L;

	/**
	 * 用户id
	 */
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
     * 邮箱
     */
    private String email;
 
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 状态：1-正常，0-禁用
     */
    private Integer status;
    
    /**
     * 状态：1-正常，0-被锁住
     */
    private Integer isLocked;
    
	/**
	 * 备注
	 */
	private String remarks;
	
    /**
     * 创建时间
     */
    private Date createdTime;
 
    /**
     * 修改时间
     */
    private Date updatedTime;
    
    /**
     * 一个用户对应多个角色
     */
    private Set<Role> roles = new HashSet<>();
}
