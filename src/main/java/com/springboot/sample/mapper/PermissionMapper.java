package com.springboot.sample.mapper;

import java.util.List;

import com.springboot.sample.entity.Permission;

public interface PermissionMapper {
	
	List<Permission> getPermissionsByUserName(String userName);
}
