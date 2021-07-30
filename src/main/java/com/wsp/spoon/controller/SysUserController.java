package com.wsp.spoon.controller;

import cn.hutool.core.util.StrUtil;
import com.wsp.spoon.domain.AjaxResult;
import com.wsp.spoon.domain.SysUser;
import com.wsp.spoon.page.TableDataInfo;
import com.wsp.spoon.service.SysUserService;
import com.wsp.spoon.util.SpoonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/user")
    public String menuList() {
        return "sys_user/user";
    }

    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SysUser sysUser=new SysUser();
        sysUser.setSex(1);
        sysUser.setAge(27);
        sysUser.setFlag(true);
        mmap.put("sysUser", sysUser);
        return "sys_user/add";
    }

    /**
     * 新增保存菜单
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUser sysUser) {
        if (sysUser.getFlag()) {
            sysUser.setStatus(1);
        } else {
            sysUser.setStatus(2);
        }
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setSalt(SpoonUtil.randomSalt());
        sysUser.setPassword(sysUserService.encryptPassword(sysUser.getUsername(),sysUser.getPassword(),sysUser.getSalt()));
        return toAjax(sysUserService.insertUser(sysUser));
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser sysUser){
        startPage();
        List<SysUser> userList = sysUserService.selectUserList(sysUser);
        return getDataTable(userList);
    }
    /**
     * 删除用户
     */
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") int id) {
        return toAjax(sysUserService.deleteUserById(id));
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable("id") int id, ModelMap mmap) {
        SysUser sysUser=sysUserService.selectUserById(id);
        if (sysUser.getStatus() == 1) {
            sysUser.setFlag(true);
        } else {
            sysUser.setFlag(false);
        }
        mmap.put("sysUser", sysUser);
        return "sys_user/edit";
    }
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUser sysUser) {
        if (sysUser.getFlag()) {
            sysUser.setStatus(1);
        } else {
            sysUser.setStatus(2);
        }
        if(!StrUtil.isNotEmpty(sysUser.getSalt())){
            sysUser.setSalt(SpoonUtil.randomSalt());
        }
        sysUser.setPassword(sysUserService.encryptPassword(sysUser.getUsername(),sysUser.getPassword(),sysUser.getSalt()));
        sysUser.setUpdateTime(new Date());
        return toAjax(sysUserService.updateUser(sysUser));
    }

    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(@RequestParam(value = "ids[]") String[] ids)
    {
        try
        {
            return toAjax(sysUserService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
