package com.wsp.spoon.controller;

import cn.hutool.core.util.StrUtil;
import com.wsp.spoon.domain.AjaxResult;
import com.wsp.spoon.domain.SysRole;
import com.wsp.spoon.domain.SysUser;
import com.wsp.spoon.page.TableDataInfo;
import com.wsp.spoon.service.SysRoleService;
import com.wsp.spoon.util.SpoonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/role")
    public String roleList() {
        return "sys_role/role";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysRole sysRole){
        startPage();
        List<SysRole> roleList = sysRoleService.selectRoleList(sysRole);
        return getDataTable(roleList);
    }

    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SysRole sysRole=new SysRole();
        sysRole.setFlag(true);
        mmap.put("sysRole", sysRole);
        return "sys_role/add";
    }

    /**
     * 新增保存菜单
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysRole sysRole) {
        if (sysRole.getFlag()) {
            sysRole.setStatus(1);
        } else {
            sysRole.setStatus(2);
        }
        sysRole.setCreateTime(new Date());
        sysRole.setUpdateTime(new Date());
        return toAjax(sysRoleService.insertRole(sysRole));
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable("id") int id, ModelMap mmap) {
        SysRole sysRole=sysRoleService.selectRoleById(id);
        if (sysRole.getStatus() == 1) {
            sysRole.setFlag(true);
        } else {
            sysRole.setFlag(false);
        }
        mmap.put("sysRole", sysRole);
        return "sys_role/edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysRole sysRole) {
        if (sysRole.getFlag()) {
            sysRole.setStatus(1);
        } else {
            sysRole.setStatus(2);
        }
        sysRole.setUpdateTime(new Date());
        return toAjax(sysRoleService.updateRole(sysRole));
    }

    @GetMapping("/selectRole")
    @ResponseBody
    public List<SysRole> selectRole(){
        List<SysRole> roleList = sysRoleService.selectRoleList(new SysRole());
        return roleList;
    }


}
