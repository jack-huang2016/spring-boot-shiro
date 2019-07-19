package com.springboot.sample.mapper;

import java.util.List;

import com.springboot.sample.entity.Role;

public interface RoleMapper {

	List<Role> getRolesByUserName(String userName);
}
