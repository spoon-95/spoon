package com.wsp.spoon.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.wsp.spoon.domain.AjaxResult;
import com.wsp.spoon.domain.SysMenu;
import com.wsp.spoon.service.SysMenuService;
import com.wsp.spoon.util.SpoonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
    private static final Logger log = LoggerFactory.getLogger(SysMenuController.class);
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/importMenu")
    @ResponseBody
    public AjaxResult importMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");
        //获取上传的菜单Json文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = null;
        Map map = multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
            Object obj = i.next();
            multipartFile = (MultipartFile) map.get(obj);
        }
        JSONObject jb = JSONUtil.readJSONObject(SpoonUtil.multipartFileToFile(multipartFile), Charset.forName("utf-8"));
        log.info(jb.toString());
        //清空表
        sysMenuService.truncateMenu();
        //插入菜单
        sysMenuService.insertMenu((JSONArray) jb.get("menuInfo"), 0, 1);
        AjaxResult ajax = AjaxResult.success();
        return ajax;

    }

    @GetMapping("/list")
    @ResponseBody
    public JSONObject list(SysMenu menu) {
        JSONObject jb = new JSONObject();
        List<SysMenu> menuList = sysMenuService.selectMenuList();
        jb.set("code", 0);
        jb.set("msg", "");
        jb.set("count", 19);
        jb.set("data", menuList);
        return jb;
    }

    /**
     * 参数key  用于cache菜单数据的key
     *
     * @param parentId
     * @param key
     * @return
     */
    @GetMapping("/menuJson/{parentId}/{key}")
    @ResponseBody
    public JSONArray menuJson(@PathVariable("parentId") int parentId, @PathVariable("key") String key) {
        JSONArray ja = sysMenuService.getMenuJson(parentId, key);
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(0);
        sysMenu.setName("无");
        ja.add(JSONUtil.parse(sysMenu));
        return ja;
    }

    @GetMapping("/menu")
    public String menuList() {
        return "sys_menu/menu" ;
    }

    @GetMapping("/edit/{id}")
    public String menuEdit(@PathVariable("id") int id, ModelMap mmap) {
        mmap.put("menu", sysMenuService.selectMenuById(id));
        return "sys_menu/edit" ;
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMenu menu) {
        int i = sysMenuService.updateMenu(menu);
        return i > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") int parentId, ModelMap mmap) {
        SysMenu menu = new SysMenu();
        if (ObjectUtil.isNull(parentId)) {
            menu.setParentId('0');
        } else {
            menu.setParentId(parentId);
        }
        mmap.put("menu", menu);
        return "sys_menu/add" ;
    }

    /**
     * 新增保存菜单
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMenu menu) {
        int i = sysMenuService.insertMenu(menu);
        return i > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除菜单
     */
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") int id) {
        int i = sysMenuService.deleteMenuById(id);
        return i > 0 ? AjaxResult.success() : AjaxResult.error();
    }


}
