package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 角色权限
 */
@Data
@AllArgsConstructor
public class SysRolePermission {

    private int id;

    private int roleId;

    private int permissionId;


}
