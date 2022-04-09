package com.zzl.smartcommunitymanagement.controller;

import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result login(@RequestBody String name,@RequestBody String password) {
        ScmUser scmUser = scmUserService.findByNameAndPassword(name,password);
        if (scmUser != null){

        }
        return new Result(false,200,"请求成功");
    }

    @RequestMapping("/searchByName")
    public Result searchByName(@RequestBody String name) {
        List<ScmUser> list = scmUserService.searchByName(name);
        return new Result(true,StatusCode.OK,"查询用户成功",list);
    }
}
