package com.wsp.spoon.mapper;

import com.wsp.spoon.domain.SysRole;

import java.util.List;

/**
* Created by Mybatis Generator 2021/03/08
*/
public interface SysRoleMapper {

    List<SysRole> selectRoleList(SysRole sysRole);

    int insertRole(SysRole sysRole);

    SysRole selectRoleById(int id);

    int updateRole(SysRole sysRole);
}