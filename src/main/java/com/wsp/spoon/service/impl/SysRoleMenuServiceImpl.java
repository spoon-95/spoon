package com.wsp.spoon.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wsp.spoon.mapper.SysRoleMenuMapper;
import com.wsp.spoon.domain.SysRoleMenu;
import com.wsp.spoon.service.SysRoleMenuService;
import com.wsp.spoon.generator.util.Convert;
/**
 * 角色菜单关联Service业务层处理
 * 
 * @author spoon
 * @date 2021-04-28
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService
{
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询角色菜单关联
     * 
     * @param roleId 角色菜单关联ID
     * @return 角色菜单关联
     */
    @Override
    public SysRoleMenu selectSysRoleMenuById(Long roleId)
    {
        return sysRoleMenuMapper.selectSysRoleMenuById(roleId);
    }

    /**
     * 查询角色菜单关联列表
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 角色菜单关联
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.selectSysRoleMenuList(sysRoleMenu);
    }

    /**
     * 新增角色菜单关联
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 结果
     */
    @Override
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.insertSysRoleMenu(sysRoleMenu);
    }

    /**
     * 修改角色菜单关联
     * 
     * @param sysRoleMenu 角色菜单关联
     * @return 结果
     */
    @Override
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.updateSysRoleMenu(sysRoleMenu);
    }

    /**
     * 删除角色菜单关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuByIds(String ids)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除角色菜单关联信息
     * 
     * @param roleId 角色菜单关联ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuById(Long roleId)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuById(roleId);
    }
}
