package com.wsp.spoon.service;

import cn.hutool.json.JSONArray;
import com.wsp.spoon.domain.SysMenu;

import java.util.List;

public interface SysMenuService {
    //插入菜单
    public void insertMenu(JSONArray jb, int parentId, int level);

    //清空菜单表
    public void truncateMenu();

    //查询系统菜单列表
    public List<SysMenu> selectMenuList();

    //查询菜单树状下拉Json
    public List<SysMenu> menuJson();

    //根据菜单ID查询信息
    public SysMenu selectMenuById(int id);

    //编辑菜单
    public int updateMenu(SysMenu menu);

    //插入菜单
    public int insertMenu(SysMenu menu);

    //删除菜单
    public int deleteMenuById(int id);

    //查询菜单树状Json（首页菜单）
    public JSONArray getMenuJson(int parentId, String key, int roleId);

    //查询菜单树状Json（菜单管理编辑和新增下拉选择）
    public JSONArray getMenuJson(int parentId, String key);

}
