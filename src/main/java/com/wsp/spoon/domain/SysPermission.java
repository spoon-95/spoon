package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限对象 sys_permission
 *
 * @author spoon
 * @date 2021-04-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission
{
private static final long serialVersionUID=1L;

    /** ID */
    private Long id;

    /** 权限id */
                private String permissionId;

    /** 权限名称 */
                private String name;

    /** 权限描述 */
                private String description;

    /** 权限访问路径 */
                private String url;

    /** 权限标识 */
                private String perms;

    /** 父级权限id */
                private Long parentId;

    /** 类型   0：目录   1：菜单   2：按钮 */
                private Integer type;

    /** 排序 */
                private Integer orderNum;

    /** 图标 */
                private String icon;

    /** 状态：1有效；2删除 */
                private Integer status;

}