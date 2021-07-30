package com.wsp.spoon.service.impl;


import com.wsp.spoon.mapper.SysRoleMapper;
import com.wsp.spoon.mapper.SysUserMapper;
import com.wsp.spoon.domain.SysUser;
import com.wsp.spoon.service.SysUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findAllUserInfoByUsername(String username) {
        SysUser user = sysUserMapper.findByUsername(username);

        //用户的角色集合
        /*List<SysRole> roleList = sysRoleMapper.findRoleListByUserId(user.getId());


        user.setRoleList(roleList);*/

        return user;
    }


    @Override
    public SysUser findSimpleUserInfoById(int userId) {
        return sysUserMapper.findById(userId);
    }


    @Override
    public SysUser findSimpleUserInfoByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

    @Override
    public List<SysUser> selectUserList(SysUser sysUser) {
        return sysUserMapper.selectUserList(sysUser);
    }

    @Override
    public int insertUser(SysUser sysUser) {
        return sysUserMapper.insertUser(sysUser);
    }

    @Override
    public int deleteUserById(int id) {
        return sysUserMapper.deleteUserById(id);
    }

    @Override
    public SysUser selectUserById(int id) {
        return sysUserMapper.selectUserById(id);
    }

    @Override
    public int updateUser(SysUser sysUser) {
        return sysUserMapper.updateUser(sysUser);
    }

    @Override
    public int deleteUserByIds(String[] ids) {
        return sysUserMapper.deleteUserByIds(ids);
    }

    @Override
    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex();
    }


}
