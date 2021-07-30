package com.wsp.spoon.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.wf.captcha.utils.CaptchaUtil;
import com.wsp.spoon.config.init.HomeInfo;
import com.wsp.spoon.config.init.LogoInfo;

import com.wsp.spoon.domain.AjaxResult;
import com.wsp.spoon.domain.SysUser;
import com.wsp.spoon.service.SysMenuService;
import com.wsp.spoon.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class SysController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private HomeInfo homeInfo;

    @Resource
    private LogoInfo logoInfo;

    @GetMapping("/login")
    public String login() {
        return "login" ;
    }

    @GetMapping("/index")
    public String index(ModelMap mmap) {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        mmap.put("sysUser",sysUser);
        return "index" ;
    }

    @GetMapping("/unauth")
    public String unauth() {
        return "unauth" ;
    }


    @PostMapping("/login")
    @ResponseBody
    public AjaxResult doLogin(@RequestBody SysUser sysUser, HttpServletRequest request) {
        if (!CaptchaUtil.ver(sysUser.getCaptcha(), request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return error("验证码不正确");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            SysUser user = sysUserService.findAllUserInfoByUsername(sysUser.getUsername());
            String password = sysUserService.encryptPassword(sysUser.getUsername(), sysUser.getPassword(), user.getSalt());
            UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), password);
            subject.login(token);
            return success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误" ;
            return error(msg);
        }
    }

    /**
     * 参数key  用于cache菜单数据的key
     *
     * @param parentId
     * @param key
     * @return
     */

    @GetMapping("/init/{parentId}/{key}")
    @ResponseBody
    public JSONObject init(@PathVariable("parentId") int parentId, @PathVariable("key") String key) {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        JSONObject jb = new JSONObject();
        jb.set("homeInfo", homeInfo);
        jb.set("logoInfo", logoInfo);
        jb.set("menuInfo", sysMenuService.getMenuJson(parentId, key, sysUser.getRoleId()));
        return jb;
    }

    @GetMapping("test")
    public void test(){
        int i=1/0;
    }


}
