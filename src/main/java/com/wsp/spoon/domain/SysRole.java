package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Created by Mybatis Generator 2021/03/05
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private Integer id;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Boolean flag;

    private List<SysPermission> permissionList;

    private ArrayList authids;


}