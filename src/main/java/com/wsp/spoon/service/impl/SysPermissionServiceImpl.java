package com.wsp.spoon.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wsp.spoon.mapper.SysPermissionMapper;
import com.wsp.spoon.domain.SysPermission;
import com.wsp.spoon.service.SysPermissionService;
import com.wsp.spoon.generator.util.Convert;
/**
 * 权限Service业务层处理
 * 
 * @author spoon
 * @date 2021-04-03
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService
{
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 查询权限
     * 
     * @param id 权限ID
     * @return 权限
     */
    @Override
    public SysPermission selectSysPermissionById(Long id)
    {
        return sysPermissionMapper.selectSysPermissionById(id);
    }

    /**
     * 查询权限列表
     * 
     * @param sysPermission 权限
     * @return 权限
     */
    @Override
    public List<SysPermission> selectSysPermissionList(SysPermission sysPermission)
    {
        return sysPermissionMapper.selectSysPermissionList(sysPermission);
    }

    /**
     * 新增权限
     * 
     * @param sysPermission 权限
     * @return 结果
     */
    @Override
    public int insertSysPermission(SysPermission sysPermission)
    {
        return sysPermissionMapper.insertSysPermission(sysPermission);
    }

    /**
     * 修改权限
     * 
     * @param sysPermission 权限
     * @return 结果
     */
    @Override
    public int updateSysPermission(SysPermission sysPermission)
    {
        return sysPermissionMapper.updateSysPermission(sysPermission);
    }

    /**
     * 删除权限对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysPermissionByIds(String ids)
    {
        return sysPermissionMapper.deleteSysPermissionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除权限信息
     * 
     * @param id 权限ID
     * @return 结果
     */
    @Override
    public int deleteSysPermissionById(Long id)
    {
        return sysPermissionMapper.deleteSysPermissionById(id);
    }
}
