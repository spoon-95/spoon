package com.wsp.spoon.service;

import java.util.List;
import com.wsp.spoon.domain.SysRoleMenu;

/**
 * 角色菜单关联Service接口
 * 
 * @author spoon
 * @date 2021-04-28
 */
public interface SysRoleMenuService
{
    /**
     * 查询角色菜单关联
     * 
     * @param roleId 角色菜单关联ID
     * @return 角色菜单关联
     */
     SysRoleMenu selectSysRoleMenuById(Long roleId);

    /**
     * 查询角色菜单关联列表
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 角色菜单关联集合
     */
     List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    /**
     * 新增角色菜单关联
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 结果
     */
     int insertSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色菜单关联
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 结果
     */
     int updateSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 批量删除角色菜单关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteSysRoleMenuByIds(String ids);

    /**
     * 删除角色菜单关联信息
     * 
     * @param roleId 角色菜单关联ID
     * @return 结果
     */
     int deleteSysRoleMenuById(Long roleId);

}
