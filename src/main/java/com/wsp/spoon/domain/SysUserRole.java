package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysUserRole {

    private int id;

    private int userId;

    private int roleId;

}
