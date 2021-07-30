package com.wsp.spoon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    private int id;
    private int parentId;
    private String title;
    private String name;
    private String icon;
    private String href;
    private String target;
    private int orderNum;
    private int visible;
    private int level;
    private List<SysMenu> children;
}
