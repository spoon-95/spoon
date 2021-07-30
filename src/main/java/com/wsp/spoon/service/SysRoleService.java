package com.wsp.spoon.service;

import com.wsp.spoon.domain.SysRole;

import java.util.List;

public interface SysRoleService {
    public List<SysRole> selectRoleList(SysRole sysRole);

    int insertRole(SysRole sysRole);

    SysRole selectRoleById(int id);

    int updateRole(SysRole sysRole);
}
