package com.wsp.spoon.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wsp.spoon.generator.annotation.Log;
import com.wsp.spoon.generator.enums.BusinessType;
import com.wsp.spoon.domain.SysPermission;
import com.wsp.spoon.service.SysPermissionService;
import com.wsp.spoon.domain.AjaxResult;
import com.wsp.spoon.page.TableDataInfo;


/**
 * 权限Controller
 * 
 * @author spoon
 * @date 2021-04-03
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController
{
    private String prefix = "sys_permission";

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping()
    public String list()
    {
        return prefix + "/list";
    }

    /**
     * 新增权限
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("sysPermission", new SysPermission());
        return prefix + "/add";
    }

    /**
     * 修改权限
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysPermission sysPermission = sysPermissionService.selectSysPermissionById(id);
        mmap.put("sysPermission", sysPermission);
        return prefix + "/edit";
    }



    /**
     * 查询权限列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysPermission sysPermission)
    {
        startPage();
        List<SysPermission> list = sysPermissionService.selectSysPermissionList(sysPermission);
        return getDataTable(list);
    }

    /**
     * 新增保存权限
     */
    @Log(title = "权限", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysPermission sysPermission)
    {
        return toAjax(sysPermissionService.insertSysPermission(sysPermission));
    }

    /**
     * 修改保存权限
     */
    @Log(title = "权限", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysPermission sysPermission)
    {
        return toAjax(sysPermissionService.updateSysPermission(sysPermission));
    }


    /**
     * 删除权限
     */
    @Log(title = "权限", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysPermissionService.deleteSysPermissionByIds(ids));
    }
}