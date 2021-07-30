package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 角色菜单关联对象 sys_role_menu
 *
 * @author spoon
 * @date 2021-04-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu
{
    private static final long serialVersionUID=1L;

    /** 角色ID */
    private int roleId;

    /** 菜单ID */
    private int menuId;

    private ArrayList authids;

}