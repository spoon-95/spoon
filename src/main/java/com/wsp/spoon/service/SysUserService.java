package com.wsp.spoon.service;


import com.wsp.spoon.domain.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 获取全部用户信息，包括角色，权限
     *
     * @param username
     * @return
     */
    SysUser findAllUserInfoByUsername(String username);


    /**
     * 获取用户基本信息
     *
     * @param userId
     * @return
     */
    SysUser findSimpleUserInfoById(int userId);


    /**
     * 根据用户名查找用户信息
     *
     * @param username
     * @return
     */
    SysUser findSimpleUserInfoByUsername(String username);

    /**
     * 用户列表
     * @return
     */
    List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 插入用户
     * @param sysUser
     * @return
     */
    int insertUser(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUserById(int id);

    SysUser selectUserById(int id);

    int updateUser(SysUser sysUser);

    int deleteUserByIds(String[] ids);

    public String encryptPassword(String username, String password, String salt);
}
