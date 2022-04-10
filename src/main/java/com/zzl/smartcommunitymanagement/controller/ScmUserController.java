package com.zzl.smartcommunitymanagement.controller;

import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @desc 用户管理控制层
 */
@RestController
@RequestMapping("/scmuser")
public class ScmUserController {

    @Autowired
    private ScmUserService scmUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpSession session, @RequestBody Map<String,String> request) {
        String name = "";
        String password = "";
        if (request.get("username") != null)
        {
            name = request.get("username");
        }
        if (request.get("password") != null)
        {
            password = request.get("password");
        }
        ScmUser scmUser = scmUserService.findByNameAndPassword(name,password);
        if (scmUser == null){
            return  new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
        session.setAttribute("user", scmUser);
        return new Result(true,StatusCode.OK,"请求成功",scmUser);
    }

    @RequestMapping("/searchByName")
    public Result searchByName(@RequestBody String name) {
        List<ScmUser> list = scmUserService.searchByName(name);
        return new Result(true,StatusCode.OK,"查询用户成功",list);
    }
}
