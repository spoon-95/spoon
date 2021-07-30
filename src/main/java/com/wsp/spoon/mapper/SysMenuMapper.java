package com.wsp.spoon.mapper;

import com.wsp.spoon.domain.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    //插入菜单
    public int insertSysMenu(SysMenu sysMenu);

    //清空菜单表
    public void truncateMenu();

    //查询系统菜单列表
    public List<SysMenu> selectMenuList();

    //查询系统菜单Json
    public List<SysMenu> menuJson();

    //根据菜单ID查询信息
    public SysMenu selectMenuById(int id);

    //编辑菜单
    public int updateMenu(SysMenu menu);

    //删除菜单
    public int deleteMenuById(int id);

    //根据菜单ID查询信息
    public List<SysMenu> selectMenuByPId(int parentId);

    //根据菜单ID查询信息
    public List<SysMenu> selectByPIdRoleId(int parentId,int roleId);

}
