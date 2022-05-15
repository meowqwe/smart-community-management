package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @desc 用户管理控制层
 */
@RestController
@RequestMapping("/scmuser")
public class ScmLoginController {

    @Autowired
    private ScmUserService scmUserService;

    /**
     * 用户登录并设置Session
     * @param session
     * @param request
     * @return
     * 测试完成
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpSession session, @RequestBody Map request) {
        String name = "";
        String password = "";
        if (StringUtil.isNotEmpty((String) request.get("username")))
        {
            name = (String) request.get("username");
        }
        if (StringUtil.isNotEmpty((String) request.get("password")))
        {
            password = (String) request.get("password");
        }
        ScmUser scmUser = scmUserService.findByNameAndPassword(name,password);
        if (scmUser == null){
            return  new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
        session.setAttribute("user", scmUser);
        return new Result(true,StatusCode.OK,"请求成功",scmUser);
    }

    /**
     * 用户登出并移除Session
     * @param session
     * @return
     * 接口测试完成
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return new Result(true, StatusCode.OK,"注销成功!");
    }

    /**
     * 根据用户名查找所有用户
     * @param searchMap
     * @return
     */
    @RequestMapping("/searchByName")
    @ResponseBody
    public PageResult searchByName(@RequestBody Map searchMap) {
        Page<ScmUser> list = scmUserService.searchByName(searchMap);
        return new PageResult(true,StatusCode.OK,"查询用户成功",list,list.getTotal());
    }

    /**
     * 查询所有用户
     * @param request
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Map request) {
        Page<ScmUser> list = scmUserService.findAll(request);
        if (list.isEmpty()) {
            return new PageResult(false, StatusCode.ERROR, "获取失败",null, 0l);
        }
        return new PageResult(true, StatusCode.OK, null, list, list.getTotal());
    }

    /**
     * 修改密码
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public Result updatePassword(HttpSession session, @RequestBody Map request) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        if (StringUtil.isNotEmpty((String) request.get("oldPassword"))) {
            if (!user.getUPassword().equals((String) request.get("oldPassword"))) {
                return new Result(false, StatusCode.ERROR, "旧密码错误");
            }
        }
        if (StringUtil.isNotEmpty((String) request.get("newPassword"))) {
            user.setUPassword((String) request.get("newPassword"));
        }
        scmUserService.updateUser(user);
        return new Result(true, StatusCode.OK, "密码修改成功");
    }
}
