package com.wsp.spoon.mapper;

import com.wsp.spoon.domain.SysUser;

import java.util.List;

public interface SysUserMapper {

    SysUser findByUsername(String username);


    SysUser findById(int id);


    SysUser findByUsernameAndPwd(String username, String pwd);


    List<SysUser> selectUserList(SysUser sysUser);

    int insertUser(SysUser sysUser);

    int deleteUserById(int id);

    SysUser selectUserById(int id);

    int updateUser(SysUser sysUser);

    int deleteUserByIds(String[] ids);
}
