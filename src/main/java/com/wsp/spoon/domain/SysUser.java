package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -8430087586420925524L;
    private int id;

    private String userNo;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String phone;

    private int sex;

    private int age;

    private int status;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Boolean flag;

    private int roleId;

    /**
     * 角色集合 --不单独写dto了,仅作为项目演示
     */
    private List<SysRole> roleList;

    private String captcha;


}
