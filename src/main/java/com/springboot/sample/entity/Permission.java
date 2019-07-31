package com.springboot.sample.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Permission implements Serializable{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -2922469746803518719L;

	/**
	 * 权限唯一标识ID
	 */
	private Integer id;
	
	/**
	 * 权限名称
	 */
	private String permissionName;
	
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
}
