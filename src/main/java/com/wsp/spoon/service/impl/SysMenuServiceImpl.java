package com.wsp.spoon.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.wsp.spoon.domain.SysMenu;
import com.wsp.spoon.mapper.SysMenuMapper;
import com.wsp.spoon.service.SysMenuService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @CacheEvict(value = "getMenuJson", allEntries = true)
    @Override
    @Transactional
    public void insertMenu(JSONArray jb, int parentId, int level) {
        for (int i = 0; i < jb.size(); i++) {
            JSONObject parent = JSONUtil.parseObj(jb.get(i));

            SysMenu sysMenu = new SysMenu();
            sysMenu.setParentId(parentId);
            sysMenu.setTitle(parent.get("title").toString());
            sysMenu.setIcon(parent.get("icon").toString());
            sysMenu.setHref(parent.get("href").toString());
            sysMenu.setTarget(parent.get("target").toString());
            sysMenu.setOrderNum(i + 1);
            sysMenu.setVisible(0);
            sysMenu.setLevel(level);

            sysMenuMapper.insertSysMenu(sysMenu);
            JSONArray child = (JSONArray) parent.get("child");
            if (child != null) {
                insertMenu(child, sysMenu.getId(), level + 1);
            }
        }

    }

    @CacheEvict(value = "getMenuJson", allEntries = true)
    @Override
    @Transactional
    public void truncateMenu() {
        sysMenuMapper.truncateMenu();
    }


    @Override
    public List<SysMenu> selectMenuList() {
        return sysMenuMapper.selectMenuList();
    }

    @Override
    public List<SysMenu> menuJson() {
        List<SysMenu> list = sysMenuMapper.menuJson();
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(0);
        sysMenu.setName("无");
        list.add(sysMenu);
        return list;
    }

    @Override
    public SysMenu selectMenuById(int id) {
        return sysMenuMapper.selectMenuById(id);
    }

    @CacheEvict(value = "getMenuJson", allEntries = true)
    @Override
    public int updateMenu(SysMenu menu) {
        return sysMenuMapper.updateMenu(menu);
    }

    @CacheEvict(value = "getMenuJson", allEntries = true)
    @Override
    public int insertMenu(SysMenu menu) {
        return sysMenuMapper.insertSysMenu(menu);
    }

    @CacheEvict(value = "getMenuJson", allEntries = true)
    @Override
    public int deleteMenuById(int id) {
        return sysMenuMapper.deleteMenuById(id);
    }

    @Cacheable(value = "getMenuJson", key = "#key")
    @Override
    public JSONArray getMenuJson(int parentId, String key,int roleId) {
        JSONArray parent = JSONUtil.parseArray(sysMenuMapper.selectByPIdRoleId(parentId,roleId));
        for (int i = 0; i < parent.size(); i++) {
            JSONObject jb = (JSONObject) parent.get(i);
            JSONArray child = getMenuJson((Integer) jb.get("id"), key,roleId);
            if (child.size() > 0) {
                jb.set(key, child);
            }
        }
        return parent;
    }

    @Cacheable(value = "getMenuJson", key = "#key")
    @Override
    public JSONArray getMenuJson(int parentId, String key) {
        JSONArray parent = JSONUtil.parseArray(sysMenuMapper.selectMenuByPId(parentId));
        for (int i = 0; i < parent.size(); i++) {
            JSONObject jb = (JSONObject) parent.get(i);
            JSONArray child = getMenuJson((Integer) jb.get("id"), key);
            if (child.size() > 0) {
                jb.set(key, child);
            }
        }
        return parent;
    }

}
