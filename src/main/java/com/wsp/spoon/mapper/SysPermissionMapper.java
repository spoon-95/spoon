package com.wsp.spoon.mapper;

import java.util.List;
import com.wsp.spoon.domain.SysPermission;

/**
 * 权限Mapper接口
 * 
 * @author spoon
 * @date 2021-04-03
 */
public interface SysPermissionMapper 
{
    /**
     * 查询权限
     * 
     * @param id 权限ID
     * @return 权限
     */
     SysPermission selectSysPermissionById(Long id);

    /**
     * 查询权限列表
     * 
     * @param sysPermission 权限
     * @return 权限集合
     */
     List<SysPermission> selectSysPermissionList(SysPermission sysPermission);

    /**
     * 新增权限
     * 
     * @param sysPermission 权限
     * @return 结果
     */
     int insertSysPermission(SysPermission sysPermission);

    /**
     * 修改权限
     * 
     * @param sysPermission 权限
     * @return 结果
     */
     int updateSysPermission(SysPermission sysPermission);

    /**
     * 删除权限
     * 
     * @param id 权限ID
     * @return 结果
     */
     int deleteSysPermissionById(Long id);

    /**
     * 批量删除权限
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteSysPermissionByIds(String[] ids);
}
