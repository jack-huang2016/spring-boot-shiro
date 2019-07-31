package com.springboot.sample.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Role implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4858443551196604517L;

	/**
	 * 角色唯一标识符
	 */
	private Integer id; 
	
	/**
	 *  角色名称
	 */
	@NotNull(message = "角色名称不能为空")
	private String roleName; 
	
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
     * 一个角色对应多个权限或者资源
     */
    private Set<Permission> permissions = new HashSet<>();
}
