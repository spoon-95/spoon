package com.wsp.spoon.service.impl;

import com.wsp.spoon.domain.SysRole;
import com.wsp.spoon.domain.SysRoleMenu;
import com.wsp.spoon.mapper.SysRoleMapper;
import com.wsp.spoon.mapper.SysRoleMenuMapper;
import com.wsp.spoon.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysRole> selectRoleList(SysRole sysRole) {
        return sysRoleMapper.selectRoleList(sysRole);
    }

    @Override
    @Transactional
    public int insertRole(SysRole sysRole) {
        sysRoleMapper.insertRole(sysRole);
        SysRoleMenu sysRoleMenu=new SysRoleMenu();
        sysRoleMenu.setRoleId(sysRole.getId());
        sysRoleMenu.setAuthids(sysRole.getAuthids());
        return sysRoleMenuMapper.insertSysRoleMenuBatch(sysRoleMenu);
    }

    @Override
    public SysRole selectRoleById(int id) {
        return sysRoleMapper.selectRoleById(id);
    }

    @Override
    @Transactional
    public int updateRole(SysRole sysRole) {
        sysRoleMenuMapper.deleteByRoleId(sysRole.getId());
        SysRoleMenu sysRoleMenu=new SysRoleMenu();
        sysRoleMenu.setRoleId(sysRole.getId());
        sysRoleMenu.setAuthids(sysRole.getAuthids());
        sysRoleMenuMapper.insertSysRoleMenuBatch(sysRoleMenu);
        return sysRoleMapper.updateRole(sysRole);
    }
}
